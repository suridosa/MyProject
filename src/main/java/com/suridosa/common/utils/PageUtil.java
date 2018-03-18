package com.suridosa.common.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.suridosa.common.domain.CommonDomain;

/**
 * <pre>
 * �Խ��� ������������ ó���ϴ� JavaBean ��ü
 * 
 * ��뿹
 * 	PageBean pBean = new PageBean();
 * 	pBean.setThisPage(page);
 * 	pBean.setRowPerPage(10);
 * 		.
 * 		.
 * 		.
 * 	pBean.setGroup();
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class PageUtil implements Serializable{
	
	
	public PageUtil() {
	}
	
	public PageUtil(int totalRow, int rowPerPage, int thisPage){
		setTotalRow(totalRow);
		setRowPerPage(rowPerPage);
		setThisPage(thisPage);
	}

	protected long totalRow = 0;
	protected int rowPerPage = 10;
	protected int pageGroup = 10;
	protected int totalPage = 1;
	protected int thisPage = 1;
	protected String page = "";

	/**
	 * �������� �����Ѵ�.
	 * @param page ��������ȣ
	 */
	public void setPage(String page){
		this.page = page;
	}
	
	/**
	 * ��ü ������ �����Ѵ�.
	 * @return long ��ü����
	 */
	public long getTotalRow() {
	  return this.totalRow;
	}

	/**
	 * ��ü ������ �����Ѵ�.
	 * @param totalrow ��ü����
	 */
	public void setTotalRow(int totalrow) {
	  this.totalRow = totalrow;
	}
	
	/**
	 * ��ü ������ �����Ѵ�.
	 * @param totalrow ��ü����
	 */
	public void setTotalRow(Object o) {		
		if(o instanceof BigDecimal) {
			this.totalRow = ((BigDecimal)o).intValue();
		} else if(o instanceof Integer) {
			this.totalRow = ((Integer)o).intValue();
		} else if(o instanceof Long) {
			this.totalRow = ((Long)o).longValue();
		}
	}

	/**
	 * �������� �Խõ� ������ �����Ѵ�.
	 * @return long �������� ����
	 */
	public int getRowPerPage() {
	  return this.rowPerPage;
	}

	/**
	 * �������� �Խõ� ������ �����Ѵ�.
	 * @param row �������� ����
	 */
	public void setRowPerPage(int row) {
	  this.rowPerPage = row;
	}

	public int getPageGroup() {
	  return this.pageGroup;
	}

	public void setPageGroup(int group) {
	  this.pageGroup = group;
	}


	/**
	 * ���� �������� �����Ѵ�.
	 * @return long ����������
	 */
	public int getThisPage() {
	  return this.thisPage;
	}

	/**
	 * ���� �������� �����Ѵ�.
	 * @param page ����������
	 */
	public void setThisPage(int page) {
	  this.thisPage = page;
	}

	/**
	 * ���� �������� �����Ѵ�.
	 * @param page ����������
	 */
	public void setThisPage(String page) {
	  if (page != null && !page.equals("")) this.thisPage = Integer.parseInt(page);
	}

	/**
	 * ��ü �������� �����Ѵ�.
	 * @param page ��ü������ ����
	 */
	public void setTotalPage(int page) {
	  this.totalPage = page;
	}

	/**
	 * ��ü ������ ������ �����Ѵ�.
	 *
	 */
	public void setGroup() {

	  double rowPerPage = this.rowPerPage;
	  Double doubleTotalPage = new Double(Math.ceil(totalRow/rowPerPage));
	  int totalPage = doubleTotalPage.intValue();
	  setTotalPage(totalPage);
	}
    
    /**
     * <pre>
     * ������ �׺���̼ǹ� ����<br>
     * &lt;&lt;  &lt;  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]  [10]  &gt;  &gt;&gt; ������ 
     * ���̰��̼� �� ����
     * </pre>
     * 
     * @param context web context path
     * @param width �׺���̼ǹٸ� �����ϴ� Table�� width
     * @return ������ �׺���̼ǹٿ� �ش��ϴ� html 
     */
    public String getPageNavi(){
   
    	StringBuffer pageString = new StringBuffer();
    	
    	if(this.getTotalRow() > 0) {
	    	long nowPage = this.getThisPage();
			long prevPage = 0, nextPage = 0, pagingStart = 0, pagingEnd = 0;
			
			
			pagingStart = ((nowPage-1)/this.getPageGroup())*this.getPageGroup() + 1;
			pagingEnd = (this.getTotalPage() < pagingStart + (this.getPageGroup()-1) ? this.getTotalPage() : pagingStart+(this.getPageGroup()-1));
			
			if(nowPage > 1) {
				prevPage = nowPage - 1;
			} else {
				prevPage = pagingStart;
			}
			
			if(nowPage < this.getTotalPage()){
				nextPage = nowPage + 1;
			} else {
				nextPage = nowPage;
			}
			
			pageString.append("<div class='table_paging'>") ;
			pageString.append("<span onClick=\"goPage(1)\" style=\"cursor:pointer\"><img src='/resources/images/arrow_pre.gif' width='9px' height='9px' border='0'></span>&nbsp;&nbsp;") ;
			pageString.append("<span onClick=\"goPage(" + prevPage + ")\" style=\"cursor:pointer\"><img src='/resources/images/arrow_left.gif' width='9px' height='9px' border='0'></span>&nbsp;&nbsp;&nbsp;") ;
			
			for(long i=pagingStart;i<=pagingEnd;i++) {
				if(i==nowPage) {
					pageString.append("<strong style='font-size:16px;'>" + i + "</strong> ");
				} else {
					pageString.append("<span onclick='goPage(" + i + ")' style='cursor:pointer;font-size:14px'>" + i + "</span> ");
				}
			}
			pageString.append("&nbsp;&nbsp;&nbsp;<span class=\"img cursor\" onClick=\"goPage(" + nextPage + ")\" style=\"cursor:pointer\"><img src='/resources/images/arrow_right.gif' width='9px' height='9px' border='0'></span> ") ;
			pageString.append("&nbsp;&nbsp;<span class=\"img cursor\" onClick=\"goPage(" + this.getTotalPage() + ")\" style=\"cursor:pointer\"><img src='/resources/images/arrow_next.gif' width='9px' height='9px' border='0'></span>") ;
			pageString.append("&nbsp;&nbsp;&nbsp;&nbsp;(Total : "+ this.getTotalRow() +")") ;
			pageString.append("</div>") ;
    	}

        return pageString.toString();
    }
    
	/**
	 * ���� �������� ������ �Խù���ȣ�� �����Ѵ�.
	 * @return long 
	 */
	public long getEndIndex() {
		long endIndex = 0;
		if(thisPage == 0 || thisPage == 1){
			endIndex = rowPerPage;
		}else{
			endIndex = thisPage*rowPerPage;
		}
		return endIndex;
	}

	/**
	 * ���� �������� ù��° �Խù���ȣ�� �����Ѵ�.
	 * @return long
	 */
	public long getStartIndex() {
		long startIndex = 0;
		if(thisPage == 0 || thisPage == 1){
			startIndex = 1;
		}else{
			startIndex = (thisPage-1)*rowPerPage + 1;
		}
		return startIndex;
	}

	/**
	 * ��ü ������ ������ �����Ѵ�.
	 * @return long
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * ����Ʈ �ȿ� �ִ� total cnt�� �����Ѵ�. 
	 * @param list
	 * @param fieldNm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public long getTotalRow(List list, String fieldNm) {
		
		if(list!=null && list.size()>0) {
			Object obj = list.get(0);
			
			if( obj instanceof Map) {
				Map map = (Map)obj;
				setTotalRow(map.get(fieldNm)) ;
			} else if( obj instanceof CommonDomain ) {
				CommonDomain cd = (CommonDomain)obj;
				setTotalRow(cd.getTotalRow()) ;				
			}
		}
		
		return getTotalRow() ;
	}

	/**
	 * �Ѿ�� Bean�� ������ ������ �����Ѵ�. 
	 * @param domain
	 * @param rowsPerPage �������� Rows ��
	 * @param pageGroupCounts �������׷쳻 ������ ��
	 */
	@SuppressWarnings("rawtypes")
	public void setPageInfo(CommonDomain domain, int ... pageInfo) {
				
		for(int num : pageInfo) {
			this.setRowPerPage(num);
		}
		
		this.setThisPage(domain.getCurPage()) ;
		domain.setStartIndex(this.getStartIndex()) ;// ���� index
		domain.setEndIndex(this.getEndIndex()) ; // ���� index
		
	}
	
	/**
	 * ��ȸ�ѰǼ� ����, ������ ���� ����, ������ �׺���̼ǿ� HTML �ۼ�  
	 * @param list
	 * @param fieldName
	 * @param domain
	 */
	public void setPageGroup(List<Object> list, String fieldName, CommonDomain domain) {
		this.setPageGroup(list,fieldName,domain,this.getPageGroup());
	}

	/**
	 * ��ȸ�ѰǼ� ����, ������ ���� ����, ������ �׺���̼ǿ� HTML �ۼ�  
	 * @param list
	 * @param fieldName
	 * @param domain
	 * @param pageGroup
	 */
	public void setPageGroup(List<Object> list, String fieldName, CommonDomain domain, int pageGroup) {
		this.setPageGroup(pageGroup);
		
		this.setTotalRow(this.getTotalRow(list, fieldName)) ; // �� row ��
		
		this.setGroup() ; // ����¡
		
		domain.setPaging(this.getPageNavi()) ; // ����¡ HTML
		domain.setTotalRow(this.getTotalRow()) ; // �� row

	}
	
	public void setPageGroup(CommonDomain domain,long totalrow, int pageGroup) {
		this.setPageGroup(pageGroup);

		this.setTotalRow(totalrow) ; // �� row ��
		this.setGroup() ; // ����¡
		
		domain.setPaging(this.getPageNavi()) ; // ����¡ HTML
		domain.setTotalRow(this.getTotalRow()) ; // �� row
		
	}
	
	public void setPageGroup(List<Map<String, Object>> list,CommonDomain domain, int pageGroup) {
		this.setPageGroup(pageGroup);
		
		if(list.size() > 0)
			domain.setTotalRow(((CommonDomain)list.get(0)).getTotalRow());
		else
			domain.setTotalRow(0);
		
		this.setTotalRow(domain.getTotalRow()) ; // �� row ��
		this.setGroup() ; // ����¡
		
		domain.setPaging(this.getPageNavi()) ; // ����¡ HTML
		domain.setTotalRow(this.getTotalRow()) ; // �� row
		
	}

 }
