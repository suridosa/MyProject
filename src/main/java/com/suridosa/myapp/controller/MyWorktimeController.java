package com.suridosa.myapp.controller;

import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.suridosa.myapp.service.MyWorktimeDomain;
import com.suridosa.myapp.service.MyWorktimeService;

@RequestMapping(value = "/worktime.do")
@Controller
public class MyWorktimeController {
	
	

	@Resource(name="worktimeService")
	private MyWorktimeService worktimeService;
	
	
	@RequestMapping(value = "/worktime.do",params="cmd=initWeb")
	public String initWeb(Locale locale, HttpServletRequest request) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		String hp_tel = request.getParameter("hp_tel");
		System.out.println("hp tel :::: "+hp_tel);
		
		List<Map<String, Object>> sawonInfoList = null;
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 초기 선언
		Gson gson = new Gson();
		
		try {
			map.put("HP_TEL", hp_tel);
			sawonInfoList = worktimeService.getSawonInfo(map);
			for( Map<String, Object> data : sawonInfoList) {
				MyWorktimeDomain domain = new MyWorktimeDomain();
				domain.setSawonNo((String)data.get("SAWON_NO")); 
				domain.setSawonNm((String)data.get("SAWON_NM")); 
			}

			// 최종적으로 배열을 하나로 묶음
			String result = gson.toJson(sawonInfoList);
			System.out.println("@@@@@@@ result :: "+result);
		    // 안드로이드에 보낼 데이터를 출력
			request.setAttribute("sawonInfo", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("serverTime", "init !! "+formattedDate );
		
		return "workTime";
	}
	
	@RequestMapping(value = "/worktime.do",params="cmd=initMobile")
	public String initMobile(Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			
			String result = getSawonInfo(request, response);
			
			OutputStream out1 = response.getOutputStream();
			out1.write(result.getBytes("UTF-8"));
			out1.flush();
			out1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/worktime.do",params="cmd=regStart")
	public String regStart(Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		String sawon_no = request.getParameter("sawon_no");
		System.out.println("sawon_no :::: "+sawon_no);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			
			map.put("SAWON_NO", sawon_no);
			map.put("ACCEPT_IP", request.getRemoteAddr());
			
			worktimeService.regStart(map);
			
			String result = getSawonInfo(request, response);
			
			OutputStream out1 = response.getOutputStream();
			out1.write(result.getBytes("UTF-8"));
			out1.flush();
			out1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping(value = "/worktime.do",params="cmd=regEnd")
	public String regEnd(Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		String sawon_no = request.getParameter("sawon_no");
		System.out.println("sawon_no :::: "+sawon_no);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			
			map.put("SAWON_NO", sawon_no);
			
			worktimeService.regEnd(map);
			
			String result = getSawonInfo(request, response);
			
			OutputStream out1 = response.getOutputStream();
			out1.write(result.getBytes("UTF-8"));
			out1.flush();
			out1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	private String getSawonInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String hp_tel = request.getParameter("hp_tel");
		System.out.println("hp tel :::: "+hp_tel);
		
		List<Map<String, Object>> sawonInfoList = null;
		
		Map<String,Object> map = new HashMap<String,Object>();
		String result = "";
		
		try {
			
			map.put("HP_TEL", hp_tel);
			sawonInfoList = worktimeService.getSawonInfo(map);
			
			MyWorktimeDomain domain = new MyWorktimeDomain();
			for( Map<String, Object> data : sawonInfoList) {
				domain.setSawonNo((String)data.get("SAWON_NO")); 
				domain.setSawonNm((String)data.get("SAWON_NM")); 
				domain.setStartDt((String)data.get("START_DT")); 
				domain.setEndDt  ((String)data.get("END_DT")); 
				domain.setCurrDate((String)data.get("CURR_DATE")); 
				domain.setStatus((String)data.get("STATUS")); 
			}
			
			// 최종적으로 배열을 하나로 묶음
			Gson gson = new Gson();
			result = gson.toJson(domain);
			System.out.println("@@@@@@@ result :: "+result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
