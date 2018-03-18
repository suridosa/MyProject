package com.suridosa.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.suridosa.common.domain.CommonDomain;

@Controller
public abstract class BaseController {

	@Value("${paging.kor.rowPerPage}")
	private String kor_rowPerPage;
	
	@Value("${paging.kor.pageGroup}")
	private String kor_rowPerGroup;	

	@Value("${paging.eng.rowPerPage}")
	private String eng_rowPerPage;
	
	@Value("${paging.eng.pageGroup}")
	private String eng_rowPerGroup;	
	
	/**
	 * Log 
	 *
	 * @param  
	 * @return Log
	 * @throws 
	*/
	protected Log getLogger() {
		return LogFactory.getLog(this.getClass());
	}
		
 	/**
 	 * 에러메시지 설정
 	 * 
 	 * @param mav
 	 * @param progID
 	 * @param errorCode
 	 * @param errorMsg1
 	 * @param errorMsg2
 	 * @throws Exception
 	 */
 	protected void setErrorMsg(ModelAndView mav, String progID, String errorCode, String errorMsg1, String errorMsg2) {
 		if(mav!=null) {
	 		mav.addObject("progID",progID);
	 		mav.addObject("errorCode",errorCode);
	 		mav.addObject("errorMsg1",errorMsg1);
	 		mav.addObject("errorMsg2",errorMsg2);
	 		mav.setViewName("redirect:/error/default_error.jsp") ;
 		}
 	}
 	
 	/**
 	 * 세션정보를 Domain 에 저장
 	 * @param session
 	 * @param form
 	 */
	public static void  setSessionData(HttpSession session, CommonDomain domain) {

		// 필요시 세션정보를 CommonDomain에 저장. (아래 샘플)
		Map<String,Object> m_session = new HashMap<String,Object>();
		
//		Enumeration em = session.getAttributeNames();
//		while(em.hasMoreElements()) {
//			String key = (String)em.nextElement();
//			
//			
//			String value = (String)session.getAttribute(key);
//			m_session.put(key, value);
//		}
		m_session.put("s_id"	, session.getAttribute("s_id"));
		m_session.put("s_name"	, session.getAttribute("s_name"));		
   
		domain.setS_user_id((String)session.getAttribute("s_id"));     
		domain.setS_user_nm((String)session.getAttribute("s_name"));     
    
		domain.setSession(m_session);
 	}
	
	/**
	 * pageing 
	 *
	 * @param  
	 * @return getRowPerPage
	 * @throws 
	*/
	protected int getRowPerPage(String lang) {
		int row = 20;
		String page_row="";
		if("KO".equals(lang)){
			page_row = kor_rowPerPage;
		}else{
			page_row = eng_rowPerPage;
		}
		
		if(page_row!=null && page_row.length() > 0){
			row = Integer.parseInt(page_row);
		}
		return row;
	}
	
	/**
	 * pageing 
	 *
	 * @param  
	 * @return getpageGroup
	 * @throws 
	*/
	protected int getpageGroup(String lang) {
		int group = 10;
		String page_group="";
		if("KO".equals(lang)){
			page_group = kor_rowPerGroup;
		}else{
			page_group = eng_rowPerGroup;
		}
		
		if(page_group!=null && page_group.length() > 0){
			group = Integer.parseInt(page_group);
		}
		return group;
	}
}

