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
		
		// [2-1]. urlConn ����.
		urlConn.setRequestMethod("GET"); // URL ��û�� ���� �޼ҵ� ���� : POST.
		urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset ����.
		urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");
		urlConn.setRequestProperty("Authorization", "KakaoAK b15eb9ffbd0952470d48f5f995d69ece"); //API KEY
		
		// [2-2]. parameter ���� �� ������ �о����.
		//String strParams = sbParams.toString(); //sbParams�� ������ �Ķ���͵��� ��Ʈ������ ����. ��)id=id1&pw=123;
		//OutputStream os = urlConn.getOutputStream();
		//os.write(strParams.getBytes("UTF-8")); // ��� ��Ʈ���� ���.
		//os.flush(); // ��� ��Ʈ���� �÷���(����)�ϰ� ���۸� �� ��� ��� ����Ʈ�� ���� ����.
		//os.close(); // ��� ��Ʈ���� �ݰ� ��� �ý��� �ڿ��� ����.
		
		// [2-3]. ���� ��û Ȯ��.
		// ���� �� null�� �����ϰ� �޼��带 ����.
		if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK)
		return null;
		
		// [2-4]. �о�� ����� ����.
		// ��û�� URL�� ��¹��� BufferedReader�� �޴´�.
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
		
		// ��¹��� ���ΰ� �� �տ� ���� ����.
		String line;
		
		// ������ �޾ƿ� ��ģ��.
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
