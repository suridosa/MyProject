package com.suridosa.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
/**
 * JSON���� ������ �ʿ��� �Լ���
 * @auther ddakker 2013. 12. 12.
 */
public class JsonUtil {
    private static final Log log = LogFactory.getLog(JsonUtil.class);
    /**
     * 2���� �迭�� �θ�/�ڽ� ������ �����͸� Ʈ���������� �糪�� �Ѵ�.
     * @param list          2���� �迭
     * @param rootId        �ֻ��� id
     * @param idKey         ����ũ�� Ű(id�� �� �ʵ��)
     * @param pIdKey        �θ�Ű(pId�� �� �ʵ��)
     * @param titleKey      �޴����� ǥ�õ� �ʵ��
     * @return
     * @auther ddakker 2013. 12. 12.
     */
    public static List<Map<String, Object>> convertorTreeMap(final List<Map<String, Object>> list, String rootId, final String idKey, final String pIdKey, final String titleKey){
        return convertorTreeMap(list, rootId, idKey, pIdKey, titleKey, null);
    }
    /**
     * 2���� �迭�� �θ�/�ڽ� ������ �����͸� Ʈ���������� �糪�� �Ѵ�.
     * @param list          2���� �迭
     * @param rootId        �ֻ��� id
     * @param idKey         ����ũ�� Ű(id�� �� �ʵ��)
     * @param pIdKey        �θ�Ű(pId�� �� �ʵ��)
     * @param titleKey      �޴����� ǥ�õ� �ʵ��
     * @param orderKey      ������ �ʿ��Ѱ�� ���� �ʵ��
     * @return
     * @auther ddakker 2013. 12. 12.
     */
    @SuppressWarnings("unchecked")
	public static List<Map<String, Object>> convertorTreeMap(List inList, String rootId, final String idKey, final String pIdKey, final String titleKey, final String orderKey){
        List<Map<String, Object>> treeList = new ArrayList<Map<String,Object>>();   // ���� Ʈ��
         
        if( inList == null || inList.size() == 0 )  throw new RuntimeException("List<Map> �����Ͱ� �����ϴ�.");
        if( inList.get(0) == null )                 throw new RuntimeException("Map �����Ͱ� �����ϴ�.");
         
        final List<Map<String, Object>> list = new ArrayList<Map<String,Object>>(); // ����������(Bean�ϰ�� Map���� ��ȯ)
        Iterator iter;
        for( iter=inList.iterator(); iter.hasNext(); ) {
            try{
                Object obj = iter.next();
                if( obj instanceof Map ) {
                    list.add((Map<String, Object>) obj);
                }else{
                    list.add((Map<String, Object>) obj);
                    //list.add((Map<String, Object>) BeanUtils.describe(obj));
                }
            }catch (Exception e) {
                throw new RuntimeException("Collection -> List<Map> ���� ��ȯ �� ����: " + e);
            }
        }
         
         
        int listLength = list.size();
        int loopLength = 0;
        final int[] treeLength = new int[] { 0 };
         
        while ( treeLength[0] != listLength && listLength != loopLength++ ) {
            for ( int i=0; i<list.size(); i++ ) {
                Map<String, Object> item = list.get(i);
                if ( rootId.equals((String)item.get(pIdKey)) ) {
                    Map<String, Object> view = new HashMap<String, Object>(item);
                    view.put("name", item.get(titleKey));
                    view.put("children", new ArrayList<Map<String,Object>>());
                     
                    treeList.add(view);
                    list.remove(i);
                     
                    treeLength[0]++;
                     
                     
                    if( orderKey != null ){
                        Collections.sort(treeList, new Comparator<Map<String, Object>>(){
                            public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
                                // TODO Auto-generated method stub
                                return ((String)arg0.get(orderKey)).compareTo((String)arg1.get(orderKey));
                            }
                        });
                    }
                    //view.put("isFolder", "true");
                     
                    break;
                }else{
                    new InnerClass(){
                        public void getParentNode(List<Map<String, Object>> children, Map<String, Object> item ) {
                            for ( int i=0; i<children.size(); i++ ) {
                                Map<String, Object> child = children.get(i);
                                if ( child.get(idKey).equals(item.get(pIdKey)) ) {
                                    Map<String, Object> view = new HashMap<String, Object>(item);
                                    view.put("name", item.get(titleKey));
                                    view.put("children", new ArrayList<Map<String,Object>>());
                                    ((List<Map<String,Object>>) child.get("children")).add(view);
                                     
                                    treeLength[0]++;
                                     
                                    list.remove(list.indexOf(item));
                                    //view.put("isFolder", "true");
                                     
                                    if( orderKey != null ){
                                        Collections.sort(((List<Map<String,Object>>) child.get("children")), new Comparator<Map<String, Object>>(){
                                            public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
                                                // TODO Auto-generated method stub
                                                return ((String)arg0.get(orderKey)).compareTo((String)arg1.get(orderKey));
                                            }
                                        });
                                    }
                                    break;
                                }else{
                                    if( ((List<Map<String,Object>>) child.get("children")).size() > 0 ){
                                        getParentNode((List<Map<String,Object>>) child.get("children"), item);
                                    }
                                }
                            }
                        }
                    }.getParentNode(treeList, item);
                }
            }
        }
        return treeList;
    }
     
    public interface InnerClass {
        public void getParentNode(List<Map<String, Object>> list, Map<String, Object> item );
    }
     
}
