package com.suridosa.common.domain;

import java.util.Map;

/**
 * 공통 Value Object
 * 
 */

public class CommonDomain {

	/** 조회 처리 */
	protected String doSearch          = "Y";// 검색여부
	protected String direction            = ""; // Page Direction
	protected String orderByColumn = ""; // 정렬컬럼명
	protected String orderByStatus    = ""; // 정렬상태(ASC, DESC)
	protected String cmd                   = ""; // command값
	protected String rtnMessage       = ""; // return message
	protected String system_no         = ""; // 시스템번호
	
	protected String top_pgm_name  ="";  // 프로그램명
	protected String top_pgm_no       ="";  // 프로그램명

	/** 페이징 처리 */
	protected int curPage = 1; // 현재 페이지
	protected int rowPerPage = 10; // 페이지당 row 수
	protected long totalRow = 0; // 총 Row 수
	protected long startIndex = 1; // 시작 Index
	protected long endIndex = rowPerPage; // 종료 Index
	protected String paging = "";
	protected String currdate;
	protected String s_st;
	protected String s_date_from;
	protected String s_date_to;
	protected String s_text;
	
	protected String reg_dt;
	
	protected String user_locale="";
	
	/** 세션 */
	protected Map<String,Object> session;
	
	protected String fileInfos ="";
	
	protected String doc_id		= "";
	protected String org_file_nm	= "";
	protected String svr_file_nm	= "";
	protected String pdf_file_nm	= "";
	protected String file_path		= "";
	protected String file_size		= "";
	
	protected String my_yn		    = "";

	/** 세션공통정보 */
	String s_user_id         = ""; // 사용자id      
	String s_user_nm       = ""; // 사용자명    
	String s_comp_cd      = ""; // 회사코드    
	String s_comp_nm     = ""; // 회사명     
	String s_dept_cd        = ""; // 부서코드    
	String s_dept_nm       = ""; // 부서명     
	String s_grd_cd         = ""; // 직급코드    
	String s_grd_nm        = ""; // 직급명 
	String s_lang             = ""; // 언어코드	
	String s_login_ip        = ""; // 로그인IP   
	String s_login_time     = ""; // 로그인시간   
	String s_last_login_dt = ""; // 최종로그인시간 
	String s_last_login_ip = ""; // 최종로그인IP	
	String s_doc_path      = ""; // 문서저장위치	
		
	String s_auth			= ""; //권한	
	
	protected String accept_ip = "";
	
	String user_id		= "";
	String passwd		= "";
	String user_nm 	= "";
	String auto_login	= "";	
	
	String chk_autologin_str = "";

	String gbn = "";
	String ctg_id = "";	
	String search_word = "";
	
	public String getDoSearch() {
		return doSearch;
	}

	public void setDoSearch(String doSearch) {
		this.doSearch = doSearch;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public String getOrderByStatus() {
		return orderByStatus;
	}

	public void setOrderByStatus(String orderByStatus) {
		this.orderByStatus = orderByStatus;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getRtnMessage() {
		return rtnMessage;
	}

	public void setRtnMessage(String rtnMessage) {
		this.rtnMessage = rtnMessage;
	}

	public String getSystem_no() {
		return system_no;
	}

	public void setSystem_no(String system_no) {
		this.system_no = system_no;
	}

	public String getTop_pgm_name() {
		return top_pgm_name;
	}

	public void setTop_pgm_name(String top_pgm_name) {
		this.top_pgm_name = top_pgm_name;
	}

	public String getTop_pgm_no() {
		return top_pgm_no;
	}

	public void setTop_pgm_no(String top_pgm_no) {
		this.top_pgm_no = top_pgm_no;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

	public String getPaging() {
		return paging;
	}

	public void setPaging(String paging) {
		this.paging = paging;
	}

	public String getCurrdate() {
		return currdate;
	}

	public void setCurrdate(String currdate) {
		this.currdate = currdate;
	}

	public String getS_st() {
		return s_st;
	}

	public void setS_st(String s_st) {
		this.s_st = s_st;
	}

	public String getS_date_from() {
		return s_date_from;
	}

	public void setS_date_from(String s_date_from) {
		this.s_date_from = s_date_from;
	}

	public String getS_date_to() {
		return s_date_to;
	}

	public void setS_date_to(String s_date_to) {
		this.s_date_to = s_date_to;
	}

	public String getS_text() {
		return s_text;
	}

	public void setS_text(String s_text) {
		this.s_text = s_text;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUser_locale() {
		return user_locale;
	}

	public void setUser_locale(String user_locale) {
		this.user_locale = user_locale;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public String getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(String fileInfos) {
		this.fileInfos = fileInfos;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getOrg_file_nm() {
		return org_file_nm;
	}

	public void setOrg_file_nm(String org_file_nm) {
		this.org_file_nm = org_file_nm;
	}

	public String getSvr_file_nm() {
		return svr_file_nm;
	}

	public void setSvr_file_nm(String svr_file_nm) {
		this.svr_file_nm = svr_file_nm;
	}

	public String getPdf_file_nm() {
		return pdf_file_nm;
	}

	public void setPdf_file_nm(String pdf_file_nm) {
		this.pdf_file_nm = pdf_file_nm;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public String getMy_yn() {
		return my_yn;
	}

	public void setMy_yn(String my_yn) {
		this.my_yn = my_yn;
	}

	public String getS_user_id() {
		return s_user_id;
	}

	public void setS_user_id(String s_user_id) {
		this.s_user_id = s_user_id;
	}

	public String getS_user_nm() {
		return s_user_nm;
	}

	public void setS_user_nm(String s_user_nm) {
		this.s_user_nm = s_user_nm;
	}

	public String getS_comp_cd() {
		return s_comp_cd;
	}

	public void setS_comp_cd(String s_comp_cd) {
		this.s_comp_cd = s_comp_cd;
	}

	public String getS_comp_nm() {
		return s_comp_nm;
	}

	public void setS_comp_nm(String s_comp_nm) {
		this.s_comp_nm = s_comp_nm;
	}

	public String getS_dept_cd() {
		return s_dept_cd;
	}

	public void setS_dept_cd(String s_dept_cd) {
		this.s_dept_cd = s_dept_cd;
	}

	public String getS_dept_nm() {
		return s_dept_nm;
	}

	public void setS_dept_nm(String s_dept_nm) {
		this.s_dept_nm = s_dept_nm;
	}

	public String getS_grd_cd() {
		return s_grd_cd;
	}

	public void setS_grd_cd(String s_grd_cd) {
		this.s_grd_cd = s_grd_cd;
	}

	public String getS_grd_nm() {
		return s_grd_nm;
	}

	public void setS_grd_nm(String s_grd_nm) {
		this.s_grd_nm = s_grd_nm;
	}

	public String getS_lang() {
		return s_lang;
	}

	public void setS_lang(String s_lang) {
		this.s_lang = s_lang;
	}

	public String getS_login_ip() {
		return s_login_ip;
	}

	public void setS_login_ip(String s_login_ip) {
		this.s_login_ip = s_login_ip;
	}

	public String getS_login_time() {
		return s_login_time;
	}

	public void setS_login_time(String s_login_time) {
		this.s_login_time = s_login_time;
	}

	public String getS_last_login_dt() {
		return s_last_login_dt;
	}

	public void setS_last_login_dt(String s_last_login_dt) {
		this.s_last_login_dt = s_last_login_dt;
	}

	public String getS_last_login_ip() {
		return s_last_login_ip;
	}

	public void setS_last_login_ip(String s_last_login_ip) {
		this.s_last_login_ip = s_last_login_ip;
	}

	public String getS_doc_path() {
		return s_doc_path;
	}

	public void setS_doc_path(String s_doc_path) {
		this.s_doc_path = s_doc_path;
	}

	public String getS_auth() {
		return s_auth;
	}

	public void setS_auth(String s_auth) {
		this.s_auth = s_auth;
	}

	public String getAccept_ip() {
		return accept_ip;
	}

	public void setAccept_ip(String accept_ip) {
		this.accept_ip = accept_ip;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getAuto_login() {
		return auto_login;
	}

	public void setAuto_login(String auto_login) {
		this.auto_login = auto_login;
	}

	public String getChk_autologin_str() {
		return chk_autologin_str;
	}

	public void setChk_autologin_str(String chk_autologin_str) {
		this.chk_autologin_str = chk_autologin_str;
	}

	public String getGbn() {
		return gbn;
	}

	public void setGbn(String gbn) {
		this.gbn = gbn;
	}

	public String getCtg_id() {
		return ctg_id;
	}

	public void setCtg_id(String ctg_id) {
		this.ctg_id = ctg_id;
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	
	
	
}
