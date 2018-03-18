package com.suridosa.common.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.suridosa.common.domain.CommonDomain;

/**
 * <pre>
 * 게시판 페이지정보를 처리하는 JavaBean 객체
 * 
 * 사용예
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
	 * 페이지를 설정한다.
	 * @param page 페이지번호
	 */
	public void setPage(String page){
		this.page = page;
	}
	
	/**
	 * 전체 갯수를 리턴한다.
	 * @return long 전체갯수
	 */
	public long getTotalRow() {
	  return this.totalRow;
	}

	/**
	 * 전체 갯수를 설정한다.
	 * @param totalrow 전체갯수
	 */
	public void setTotalRow(int totalrow) {
	  this.totalRow = totalrow;
	}
	
	/**
	 * 전체 갯수를 설정한다.
	 * @param totalrow 전체갯수
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
	 * 페이지당 게시될 갯수를 리턴한다.
	 * @return long 페이지당 갯수
	 */
	public int getRowPerPage() {
	  return this.rowPerPage;
	}

	/**
	 * 페이지당 게시될 갯수를 설정한다.
	 * @param row 페이지당 갯수
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
	 * 현재 페이지를 리턴한다.
	 * @return long 현재페이지
	 */
	public int getThisPage() {
	  return this.thisPage;
	}

	/**
	 * 현재 페이지를 설정한다.
	 * @param page 현재페이지
	 */
	public void setThisPage(int page) {
	  this.thisPage = page;
	}

	/**
	 * 현재 페이지를 설정한다.
	 * @param page 현재페이지
	 */
	public void setThisPage(String page) {
	  if (page != null && !page.equals("")) this.thisPage = Integer.parseInt(page);
	}

	/**
	 * 전체 페이지를 설정한다.
	 * @param page 전체페이지 갯수
	 */
	public void setTotalPage(int page) {
	  this.totalPage = page;
	}

	/**
	 * 전체 페이지 정보를 설정한다.
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
     * 페이지 네비게이션바 생성<br>
     * &lt;&lt;  &lt;  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]  [10]  &gt;  &gt;&gt; 형태의 
     * 네이게이션 바 생성
     * </pre>
     * 
     * @param context web context path
     * @param width 네비게이션바를 구성하는 Table의 width
     * @return 페이지 네비게이션바에 해당하는 html 
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
	 * 현재 페이지의 마지막 게시물번호를 리턴한다.
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
	 * 현재 페이지의 첫번째 게시물번호를 리턴한다.
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
	 * 전체 페이지 갯수를 리턴한다.
	 * @return long
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 리스트 안에 있는 total cnt를 리턴한다. 
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
	 * 넘어온 Bean에 페이지 정보를 설정한다. 
	 * @param domain
	 * @param rowsPerPage 페이지당 Rows 수
	 * @param pageGroupCounts 페이지그룹내 페이지 수
	 */
	@SuppressWarnings("rawtypes")
	public void setPageInfo(CommonDomain domain, int ... pageInfo) {
				
		for(int num : pageInfo) {
			this.setRowPerPage(num);
		}
		
		this.setThisPage(domain.getCurPage()) ;
		domain.setStartIndex(this.getStartIndex()) ;// 시작 index
		domain.setEndIndex(this.getEndIndex()) ; // 종료 index
		
	}
	
	/**
	 * 조회총건수 설정, 페이지 정보 세팅, 페이지 네비게이션용 HTML 작성  
	 * @param list
	 * @param fieldName
	 * @param domain
	 */
	public void setPageGroup(List<Object> list, String fieldName, CommonDomain domain) {
		this.setPageGroup(list,fieldName,domain,this.getPageGroup());
	}

	/**
	 * 조회총건수 설정, 페이지 정보 세팅, 페이지 네비게이션용 HTML 작성  
	 * @param list
	 * @param fieldName
	 * @param domain
	 * @param pageGroup
	 */
	public void setPageGroup(List<Object> list, String fieldName, CommonDomain domain, int pageGroup) {
		this.setPageGroup(pageGroup);
		
		this.setTotalRow(this.getTotalRow(list, fieldName)) ; // 총 row 수
		
		this.setGroup() ; // 페이징
		
		domain.setPaging(this.getPageNavi()) ; // 페이징 HTML
		domain.setTotalRow(this.getTotalRow()) ; // 총 row

	}
	
	public void setPageGroup(CommonDomain domain,long totalrow, int pageGroup) {
		this.setPageGroup(pageGroup);

		this.setTotalRow(totalrow) ; // 총 row 수
		this.setGroup() ; // 페이징
		
		domain.setPaging(this.getPageNavi()) ; // 페이징 HTML
		domain.setTotalRow(this.getTotalRow()) ; // 총 row
		
	}
	
	public void setPageGroup(List<Map<String, Object>> list,CommonDomain domain, int pageGroup) {
		this.setPageGroup(pageGroup);
		
		if(list.size() > 0)
			domain.setTotalRow(((CommonDomain)list.get(0)).getTotalRow());
		else
			domain.setTotalRow(0);
		
		this.setTotalRow(domain.getTotalRow()) ; // 총 row 수
		this.setGroup() ; // 페이징
		
		domain.setPaging(this.getPageNavi()) ; // 페이징 HTML
		domain.setTotalRow(this.getTotalRow()) ; // 총 row
		
	}

 }
