package com.suridosa.common.utils;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

	/**
	 * ù��° ������ üũ�Ͽ� NULL �Ǵ� ""���̸� �ι�° ������ �����ϰ�, �ƴϸ� �״�� �����Ѵ�.
	 * 
	 * @param obj üũ�� ��
	 * @param str ""�� ��� ������ ��
	 * @return obj : ""�� ��� str1, �ƴҰ�� obj
	 */
	public static String nvl(Object obj, String str) {
		return obj != null && !obj.toString().equals("") ? obj.toString() : str;
	}

	/**
	 * ù��° ������ üũ�Ͽ� NULL �Ǵ� ""���̸� �ι�° ������ �����ϰ�, �ƴϸ� �״�� �����Ѵ�.
	 * 
	 * @param str üũ�� ��
	 * @param str1 ""�� ��� ������ ��
	 * @return str : ""�� ��� str1, �ƴҰ�� str
	 */
	public static String nvl(String str, String str1) {
		return str != null && !str.equals("") ? str : str1;
	}
	
	public static String nvl(String str) {
		return nvl(str,"");
	}

	/**
	 * ù��° ������ üũ�Ͽ� NULL �Ǵ� ""���̸� �ι�° ������ �����ϰ�, �ƴϸ� �״�� �����Ѵ�.(tld ���Ͽ�)
	 * 
	 * @param str üũ�� ��
	 * @param str1 ""�� ��� ������ ��
	 * @return str : ""�� ��� str1, �ƴҰ�� str
	 */
	public static String nvlstr(String str, String str1) {
		return str != null && !str.equals("") && !str.equals("null") ? str : str1;
	}

	/**
	 * tokenStr�� �����ڷ� str���� ������.
	 * 
	 * @param str üũ�� ��
	 * @param tokenStr ������
	 * @return ������ ���� �迭
	 */
	public static String[] token(String str, String tokenStr) {
		StringTokenizer stringTokenizer = new StringTokenizer(str, tokenStr);
		String tokenString[] = new String[stringTokenizer.countTokens()];

		int i = 0;
		while (stringTokenizer.hasMoreElements()) {
			tokenString[i++] = stringTokenizer.nextToken();
		}
		return tokenString;
	}

	/**
	 * ���ڿ��� ���̰ų� �� ���鹮�ڿ����� CHECK �Ѵ� <br>
	 * 
	 * @param str �������ڿ�
	 * @return ���̰ų� ������ ��� true, �ƴҰ�� false �� �����Ѵ�
	 */

	public static boolean isNull(String str) {
		if (str == null || str.trim().length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * ���ڿ��� ������ ��ȯ�Ѵ� <br>
	 * 
	 * @param str �Է¹��ڿ�
	 * @return �Է¹��ڿ��� NULL �� ��쿡�� 0, �׿ܴ� ��ȯ�� ������ �����Ѵ�.
	 */

	public static int str2int(String str) {
		if (str == null)
			return 0;
		else
			return Integer.valueOf(str).intValue();
	}

	/**
	 * ���ڿ��� Long ��ȯ�Ѵ� <br>
	 * 
	 * @param str �Է¹��ڿ�
	 * @return �Է¹��ڿ��� NULL �� ��쿡�� 0, �׿ܴ� ��ȯ�� Long �����Ѵ�.
	 */
	public static long parseLong(String str) {
		if (str == null)
			return 0;
		else
			return Long.parseLong(str);
	}

	/**
	 * html �±׸� ��ȯ��
	 * 
	 * @param p_str ���� ���ڿ�
	 * @return ��ȯ�� html
	 */
	public static String htmlToText(String p_str) {
		if (p_str == null) {
			p_str = "";
		} else {
			p_str = p_str.trim();
			p_str = StringUtil.replace(p_str, "&", "&amp;");
			p_str = StringUtil.replace(p_str, "<", "&lt;");
			p_str = StringUtil.replace(p_str, ">", "&gt;");
			p_str = StringUtil.replace(p_str, "\"", "&quot;");
			p_str = StringUtil.replace(p_str, "'", "&#39;");
			p_str = StringUtil.replace(p_str, "\"", "&#34;");
		}

		return p_str;
	}

	public static String insertComma(String src) {
		double obj = 0;
		DecimalFormat df = new DecimalFormat("###,###,###,###.##");
		
		//if(src.equals("0")) return "";
		
		try {
			obj = Double.parseDouble(src);
		} catch(Exception e) {
			return src;
		}
		
		return df.format(obj);
	}
	/**
	 * replaceToHtml�� ��ȯ�� ����(<,>,",')�� ����ġ��.
	 * 
	 * @param szDetail : �������ڿ�
	 * @return ����� ���ڿ�
	 */
	public static String textToHtml(String szDetail) {

		return szDetail.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&quot;", "\"").replaceAll("&#39;", "\'")
				.replaceAll("&amp;", "&");

	}

	/**
	 * ���ڿ��� Double ��ȯ�Ѵ� <br>
	 * 
	 * @param str �Է¹��ڿ�
	 * @return �Է¹��ڿ��� NULL �� ��쿡�� 0, �׿ܴ� ��ȯ�� Double �����Ѵ�.
	 */
	public static double parseDouble(String str) {
		if (nvl(str,"").equals(""))
			return 0;
		else
			return Double.parseDouble(str);
	}
	
	/**
	 * ���ڿ��� length ���� �涧 length ��ŭ �߶󳻰� �ڿ� pattern �� ���δ�.
	 * 
	 * @param str ���ڿ�
	 * @param length �ִ� ����(byte)
	 * @param pattern �߶󳻰� �ڿ� ���� ���ڿ�
	 * @return
	 */
	public static String overflow(String str, int length, String pattern) {
		StringBuffer sbStr = new StringBuffer(length);
		int iTotal = 0;
		for (char c : str.toCharArray()) {
			iTotal += String.valueOf(c).getBytes().length;
			if (iTotal > length) {
				break;
			}
			sbStr.append(c);
		}
		
		if(str.getBytes().length > length) {
			sbStr.append(pattern) ;
		}
		
		return sbStr.toString();
	}
	
	/**
	 * xss ����
	 * 
	 * @param contentText
	 * @return
	 */
	public static String xssFilter(String contentText) {
	    String temp = contentText;
	    temp = temp.replaceAll("(?i)<EMBED", "&lt;embed");
	    temp = temp.replaceAll("(?i)<script", "&lt;script");
	    temp = temp.replaceAll("(?i)%3script", "&lt;script");
	    temp = temp.replaceAll("(?i)javascript:", "javaxcript:");
	    temp = temp.replaceAll("%00", "");
	    temp = temp.replaceAll("(?i)expression *\\(", "expresxion(");
	    temp = temp.replaceAll("(?i)location.href *=", "l0cation.href=");
	    temp = temp.replaceAll("(?i)onKeyPress *=", "0nKeyPress=");
	    temp = temp.replaceAll("(?i)onKeyUp *=", "0nKeyUp=");
	    temp = temp.replaceAll("(?i)onBlur *=", "0nBlur=");
	    temp = temp.replaceAll("(?i)onChange *=", "0nChange=");
	    temp = temp.replaceAll("(?i)onClick *=", "0nClick=");
	    temp = temp.replaceAll("(?i)onDblClick *=", "0nDblClick=");
	    temp = temp.replaceAll("(?i)onDragDrop *=", "0nDragDrop=");
	    temp = temp.replaceAll("(?i)onError *=", "0nError=");
	    temp = temp.replaceAll("(?i)onFocus *=", "0nFocus=");
	    temp = temp.replaceAll("(?i)onload *=", "0nload=");
	    temp = temp.replaceAll("(?i)onmousedown *=", "0nmousedown=");
	    temp = temp.replaceAll("(?i)onmousemove *=", "0nmousemove=");
	    temp = temp.replaceAll("(?i)onmouseout *=", "0nmouseout=");
	    temp = temp.replaceAll("(?i)onmouseover *=", "0nmouseover=");
	    temp = temp.replaceAll("(?i)onmouseup *=", "0nmouseup=");
	    temp = temp.replaceAll("(?i)onmove *=", "0nmove=");
	    temp = temp.replaceAll("(?i)onreset *=", "0nreset=");
	    temp = temp.replaceAll("(?i)onresize *=", "0nresize=");
	    temp = temp.replaceAll("(?i)onselect *=", "0nselect=");
	    temp = temp.replaceAll("(?i)onsubmit *=", "0nsubmit=");
	    temp = temp.replaceAll("(?i)onunload *=", "0nunload=");
	    temp = temp.replaceAll("(?i)xss:*\\(*\\)", "");
	    temp = temp.replaceAll("(?i)document.cookie", "docu.cookie");
	    temp = temp.replaceAll("(?i)document.location", "docu.location");
	    temp = temp.replaceAll("(?i)document.write", "docu.write");
	    temp = temp.replaceAll("(?i)onAbort *=", "0nAbort=");
	    temp = temp.replaceAll("(?i)onKeyDown *=", "0nKeyDown=");
	    temp = temp.replaceAll("(?i)HTTP-EQUIV *=\"refresh\"", "HTTP-EQUIV=\"\"");
	    temp = temp.replaceAll("(?i)src *=", "xrc=");

	    return temp;
	}
	
	/**
	 * ���ڿ� ���ʿ� ���� ä���
	 * 
	 * @param str
	 * @param fillStr
	 * @param size
	 * @return
	 */
	public static String fillLeftStr(String str, String fillStr, int size) {
		str= nvl(str, "") ;
		if(!str.equals("")) {
			int strSize = str.length() ;
			if(strSize<size) {
				String tmpStr = "" ;
				for(int i=0; i<size-strSize; i++) {
					tmpStr += fillStr ;
				}
				str = tmpStr + str ;
			}
			
		}
		
		return str ;
	}
	
	/**
	 * ���ø� ��� ���
	 * @param str
	 * @param delim
	 * @return String[]
	 */
	public static String[] makeArray(String str, String delim) {
		String[] result = null;
		
		StringTokenizer st = new StringTokenizer(str, delim);
		int size = st.countTokens();
		int idx = 0;
		result = new String[size];
		while(st.hasMoreTokens()){
			result[idx++] = st.nextToken();
		}
		return result;
	}
	
	/**
	 * ���ø� ��� ���
	 * @param str
	 * @param delim
	 * @return ArrayList
	 */
	public static ArrayList<String> makeArrayList(String str, String delim) {
		ArrayList<String> result = new ArrayList<String>();
		
		StringTokenizer st = new StringTokenizer(str, delim);
		while(st.hasMoreTokens()){
			result.add( st.nextToken() );
		}
		return result;
	}
	
	public static String makeInquery (String str) {
		
		String result = "";
		
		str = replace(str,"'","");
		
		result = makeInQuery(str, ",");
		
		return result;
	}
	
	public static String makeInQuery (String str, String delim) {
		
		String result = "";
		
		ArrayList<String> arrStr = makeArrayList(str, delim);
		
		if(arrStr.size()>0) {
			
			for(int i = 0; i < arrStr.size(); i++ ) {
				if(i!=0) {
					result += ",";
				}
				result += "'";
				result += arrStr.get(i);
				result += "'";
			}
			
		}
		
		return result;
		
	}
	
	/**
	* ���� ���ڿ��� �����̽�("")�� ġȯ�Ѵ� <BR>
	* ��, �¿� ������ �ִ� ���ڿ��� trim �Ѵ� <br>
	*
	* @param s �Է¹��ڿ�
	* @return ġȯ�� ���ڿ�
	*/

	public static String null2space(String s)
	{
		if (s == null || s.length() == 0)
			return "";
		else
			return s.trim();
	}

    /**
     * ���ڿ��� ���ڿ��� �ٲ��ش�.
     * @param line ���� ���ڿ�
     * @param oldString ������ String 
     * @param newString ������ String
     * @return oldString�� newString���� ����� ���ڿ�
     */
    public static String replace(String line, String oldString, String newString)
    {   
        line = null2space(line);
        for(int index = 0; (index = line.indexOf(oldString, index)) >= 0; index += newString.length())
            line = line.substring(0, index) + newString + line.substring(index + oldString.length());

        return line;
    }

	/**
     * MD5 �˰������� ���ڿ� ��ȣȭ
     *
     * @author		: ���Ի�
     * @since		: 2010. 07. 06.
     * @param		: String src
     * @return
     */
	public static String MakeMD5String(String src)
	{
	    byte[] digest;
	    MessageDigest hashObj;

	    if(null == src) return src;

	    try
	    {
	        hashObj = MessageDigest.getInstance("MD5");
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	        return src;
	    }

	    digest = hashObj.digest(src.getBytes());

	    StringBuffer s = new StringBuffer();

	    for (int i = 0; i < digest.length; i++)
	    {
	        s.append(Integer.toString((digest[i] & 0xf0) >> 4, 16));
	        s.append(Integer.toString(digest[i] & 0x0f, 16));
	    }
	    return s.toString();
	}
	
	/**
	 * ���ڿ� ����
	 */
	public static String genRandomStr(int len) {
		
		StringBuffer sb = new StringBuffer();
		final String BASE_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		int ran = 0;
		
		for(int i=0; i<len;i++){
			ran = (int)(Math.random() * BASE_STR.length());
			sb.append( BASE_STR.charAt(ran)  );
		}
		
		return sb.toString();
	}
	
	
	/**
	 * ���ں�ȣ(�ѱ�ó����)
	 */
	public static String decode(String text, String s_enc, String t_enc) {
		String result = "";
		if( text != null && !"".equals(text) ) {
			try {
				result = new String(text.getBytes(s_enc),t_enc);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
}