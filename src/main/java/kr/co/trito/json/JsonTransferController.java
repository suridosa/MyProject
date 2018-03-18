package kr.co.trito.json;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class JsonTransferController {

	@RequestMapping(value = "/jsonTransfer.do")
	public String transfer(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<JsonDomain> list = new ArrayList<JsonDomain>();
		
		//데이터 
		JsonDomain  domain1 = new JsonDomain();
		domain1.setName("김개통");
		domain1.setNumber("010-2312-3098");
		domain1.setAddress("서울시 종로구 세종로 1");
		domain1.setRecvDt("2019년 20월 22일 23:00분 목요일");
		//37.36400604248047 : 126.96233367919922
		domain1.setLat("37.36400604248047");
		domain1.setLng("126.96233367919922");
		list.add(domain1);
		
		JsonDomain  domain2 = new JsonDomain();
		domain2.setName("미지정");
		domain2.setNumber("010-2312-3098");
		domain2.setAddress("서울시 종로구 세종로 1");
		domain2.setRecvDt("2019년 20월 22일 23:00분 목요일");
		domain2.setLat("37.364261");
		domain2.setLng("126.927839");
		list.add(domain2);
		
		
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
	
}
