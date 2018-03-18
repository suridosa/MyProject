package com.suridosa.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.suridosa.callpopup.domain.GeoDomain;

public class LocationUtils {
	
	public static GeoDomain getLocationInfo(String pLng, String pLat) {
		
		GeoDomain rtnDomain;
		
		//////////////////////////////////////////////////////////////////////////////////////
				
		HttpURLConnection urlConn = null;
		StringBuffer _url = new StringBuffer();
		_url.append("https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+pLng+"&y="+pLat+"&input_coord=WGS84");
		StringBuffer sbParams = new StringBuffer();
		String result = "";
		
		
		try{
		URL url = new URL(_url.toString());
		urlConn = (HttpURLConnection) url.openConnection();
		
		// [2-1]. urlConn 설정.
		urlConn.setRequestMethod("GET"); // URL 요청에 대한 메소드 설정 : POST.
		urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
		urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");
		urlConn.setRequestProperty("Authorization", "KakaoAK b15eb9ffbd0952470d48f5f995d69ece"); //API KEY
		
		// [2-2]. parameter 전달 및 데이터 읽어오기.
		//String strParams = sbParams.toString(); //sbParams에 정리한 파라미터들을 스트링으로 저장. 예)id=id1&pw=123;
		//OutputStream os = urlConn.getOutputStream();
		//os.write(strParams.getBytes("UTF-8")); // 출력 스트림에 출력.
		//os.flush(); // 출력 스트림을 플러시(비운다)하고 버퍼링 된 모든 출력 바이트를 강제 실행.
		//os.close(); // 출력 스트림을 닫고 모든 시스템 자원을 해제.
		
		// [2-3]. 연결 요청 확인.
		// 실패 시 null을 리턴하고 메서드를 종료.
		if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK)
		return null;
		
		// [2-4]. 읽어온 결과물 리턴.
		// 요청한 URL의 출력물을 BufferedReader로 받는다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
		
		// 출력물의 라인과 그 합에 대한 변수.
		String line;
		
		// 라인을 받아와 합친다.
		while ((line = reader.readLine()) != null){
		result += line;
		}
		
		//return page;
		
		} catch (MalformedURLException e) { // for URL.
			e.printStackTrace();
		} catch (IOException e) { // for openConnection().
			e.printStackTrace();
		} finally {
			if (urlConn != null)
			urlConn.disconnect();
		}
		
//		log.info("result :: "+result);
		Gson resultGson = new Gson();
		rtnDomain = resultGson.fromJson(result, GeoDomain.class);
//		log.info(">> "+domain.toString());
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		return rtnDomain;
	}

}
