package com.suridosa.callpopup.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.suridosa.callpopup.domain.Address;
import com.suridosa.callpopup.domain.CallpopupDomain;
import com.suridosa.callpopup.domain.Documents;
import com.suridosa.callpopup.domain.GeoDomain;
import com.suridosa.callpopup.domain.Meta;
import com.suridosa.callpopup.service.CallpopupService;
import com.suridosa.common.utils.LocationUtils;

@Controller
public class CallpopupController {
	
	private Log log = LogFactory.getLog(CallpopupController.class);
	
	
	@Resource(name="callpopupService")
	private CallpopupService callpopupService;
	
	
	
	@RequestMapping(value = "/Callpopup.do", params = "cmd=regUserInfo")
	public String regUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String myNumber = "";
		String myId     = "";
		String myImg    = "";
		String myNickname = "";
		
		myNumber = request.getParameter("myNumber");
		myId     = request.getParameter("myId");
		myImg    = request.getParameter("myImg");
		myNickname = request.getParameter("myNickname");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("PHONE_NO", myNumber);
		map.put("USER_ID", myId);
		map.put("NICKNAME", myNickname);
		map.put("IMAGE_PATH", myImg);
		
		int rtn = 0;
		String resultStr = "";
		
		try {
			rtn = callpopupService.regUserInfo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if( rtn > 0 ) {
			resultStr = "SUCC";
		} else {
			resultStr = "FAIL";
		}
		
		List<CallpopupDomain> list = new ArrayList<CallpopupDomain>();
		
		//데이터 
		CallpopupDomain  domain1 = new CallpopupDomain();
		domain1.setResult(resultStr);
		list.add(domain1);
		
		
		// Gson 선언
		Gson gson = new Gson();
		OutputStream out1 = null;
		
		try {
			
			out1 = response.getOutputStream();
			String jsonStr = gson.toJson(list);
			
			out1.write(jsonStr.getBytes("UTF-8"));
			out1.flush();
			
			out1.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	@RequestMapping(value = "/Callpopup.do", params = "cmd=regSendInfo")
	public String regSendInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String myNumber 		= "";
		String receiveNumber    = "";
		String receiveName    	= "";
		String lat 				= "";
		String lng 				= "";
		String address 			= "";
		
		myNumber 		=request.getParameter("myNumber");
		receiveNumber   =request.getParameter("receiveNumber");
		receiveName    	=request.getParameter("receiveName");
		lat 			=request.getParameter("lat");
		lng 			=request.getParameter("lng");
		address 		=request.getParameter("address");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("PHONE_NO"		, myNumber 		);
		map.put("SENDER_NAME"	, ""   );
		map.put("RECEIVER_NO"	, receiveNumber   );
		map.put("RECEIVER_NAME"	, receiveName    	);
		map.put("LAT"			, lat 			);
		map.put("LNG"			, lng 			);
		map.put("ADDRESS"		, address 		);
		
		log.info("@@@@@ "+map);
		
		int rtn = 0;
		String resultStr = "";
		
		try {
			rtn = callpopupService.regSendInfo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if( rtn > 0 ) {
			resultStr = "SUCC";
		} else {
			resultStr = "FAIL";
		}
		
		List<CallpopupDomain> list = new ArrayList<CallpopupDomain>();
		
		//데이터 
		CallpopupDomain  domain1 = new CallpopupDomain();
		domain1.setResult(resultStr);
		list.add(domain1);
		
		
		// Gson 선언
		Gson gson = new Gson();
		OutputStream out1 = null;
		
		try {
			
			out1 = response.getOutputStream();
			String jsonStr = gson.toJson(list);
			
			out1.write(jsonStr.getBytes("UTF-8"));
			out1.flush();
			
			out1.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	@RequestMapping(value = "/Callpopup.do", params = "cmd=getSendList")
	public String getSendList(HttpServletRequest request, HttpServletResponse response) {
		
		String myNumber 		= "";
		myNumber 		=request.getParameter("myNumber");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("PHONE_NO"		, myNumber 		);
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		
		try {
			resultList = callpopupService.getSendList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<CallpopupDomain> list = new ArrayList<CallpopupDomain>();
		
		if( resultList != null && resultList.size() > 0 ) {
			
			for(Map<String,Object> tmpMap : resultList) {
				
				CallpopupDomain  domain = new CallpopupDomain();
				domain.setName(tmpMap.get("RECEIVER_NAME").toString());
				domain.setNumber(tmpMap.get("RECEIVER_NO").toString());
				domain.setAddress(tmpMap.get("ADDRESS").toString());
				domain.setRecvDt(tmpMap.get("SEND_DT").toString());
				domain.setLat(tmpMap.get("LAT").toString());
				domain.setLng(tmpMap.get("LNG").toString());
				
				list.add(domain);
			}
			
			// Gson 선언
			Gson gson = new Gson();
			OutputStream out1 = null;
			
			try {
				
				out1 = response.getOutputStream();
				String jsonStr = gson.toJson(list);
				
				out1.write(jsonStr.getBytes("UTF-8"));
				out1.flush();
				
				out1.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return null;
	}
	
	@RequestMapping(value = "/Callpopup.do", params = "cmd=getReceiveList")
	public String getReceiveList(HttpServletRequest request, HttpServletResponse response) {
		
		String myNumber 		= "";
		myNumber 		=request.getParameter("myNumber");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("PHONE_NO"		, myNumber 		);
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		
		try {
			resultList = callpopupService.getReceiveList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<CallpopupDomain> list = new ArrayList<CallpopupDomain>();
		
		if( resultList != null && resultList.size() > 0 ) {
			
			for(Map<String,Object> tmpMap : resultList) {
				
				CallpopupDomain  domain = new CallpopupDomain();
				domain.setName(tmpMap.get("SENDER_NAME").toString());
				domain.setNumber(tmpMap.get("PHONE_NO").toString());
				domain.setAddress(tmpMap.get("ADDRESS").toString());
				domain.setRecvDt(tmpMap.get("SEND_DT").toString());
				domain.setLat(tmpMap.get("LAT").toString());
				domain.setLng(tmpMap.get("LNG").toString());
				
				list.add(domain);
			}
			
			// Gson 선언
			Gson gson = new Gson();
			OutputStream out1 = null;
			
			try {
				
				out1 = response.getOutputStream();
				String jsonStr = gson.toJson(list);
				
				out1.write(jsonStr.getBytes("UTF-8"));
				out1.flush();
				
				out1.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return null;
	}
	
	
	
	
	@RequestMapping(value = "/Callpopup.do", params = "cmd=getLocationInfo")
	public String getLocationInfo(HttpServletRequest request, HttpServletResponse response) {
		
		//내 위치 저장
		String myNumber = "";
		String myLat = "";
		String myLng = "";
		String myAddress = "";
		
		//상대방 위치 정보
		String callNumber = "";
		String callLat = "";
		String callLng = "";
		String callAddress = "";
		
		myNumber 	= request.getParameter("myNumber");
		myLat 		= request.getParameter("myLat");
		myLng 		= request.getParameter("myLng");
		
		callNumber 	= request.getParameter("callNumber");
		
		log.info("#########################################");
		log.info("myNumber >>>>>>>>>>> "+myNumber);
		log.info("myLat >>>>>>>>>>> "+myLat);
		log.info("myLng >>>>>>>>>>> "+myLng);
		log.info("callNumber >>>>>>>>>>> "+callNumber);
		log.info("#########################################");
		
		List<CallpopupDomain> list = null;
		if( callNumber != null ) {
		
			//////////////////////////////////////////////////////////////////////////////////////
			GeoDomain domain = LocationUtils.getLocationInfo(myLng, myLat); 
			log.info(">> "+domain.toString());
			
			Meta meta = domain.getMeta();
			String total_count = meta.getTotal_count();
			
			List<Documents> documents = null;
			if( Integer.parseInt(total_count) > 0 ) {
				documents = domain.getDocuments();
				
				Address adress = documents.get(0).getAddress();
				log.info(">> "+adress.toString());
				myAddress = adress.getAddress_name();
			}
			
			//내 위치 저장
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("PHONE_NO", myNumber);
			map.put("CURR_LNG", myLng);
			map.put("CURR_LAT", myLat);
			map.put("CURR_ADDRESS", myAddress);
			
			try {
				callpopupService.regMyLocation(map);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//상대방 위치 정보 가져오기
			map = new HashMap<String, Object>();
			map.put("PHONE_NO", callNumber);
			List<Map<String,Object>> locationList = null;
			Map<String, Object> callInfo = null;
			
			try {
				locationList = callpopupService.getCallLocation(map);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			list = new ArrayList<CallpopupDomain>();
			if( locationList != null ) {
				
				callInfo = locationList.get(0);
				
				//데이터 
				CallpopupDomain  domain1 = new CallpopupDomain();
				domain1.setCallNumber(callNumber);
				domain1.setCallLat(callInfo.get("CURR_LAT").toString());
				domain1.setCallLng(callInfo.get("CURR_LNG").toString());
				domain1.setCallAddress(callInfo.get("CURR_ADDRESS").toString());
				
				list.add(domain1);
				
			}
			
			//////////////////////////////////////////////////////////////////////////////////////
			// Gson 선언
			Gson gson = new Gson();		
			OutputStream out1 = null;
			
			try {
				
				out1 = response.getOutputStream();
				String jsonStr = gson.toJson(list);
				out1.write(jsonStr.getBytes("UTF-8"));
				out1.flush();
				out1.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
		return null;
	}
	
}
