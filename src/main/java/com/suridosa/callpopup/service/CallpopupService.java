package com.suridosa.callpopup.service;

import java.util.List;
import java.util.Map;

public interface CallpopupService {

	int regUserInfo(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getCallLocation(Map<String, Object> map) throws Exception;
	
	int regMyLocation(Map<String, Object> map) throws Exception;
	
	int regSendInfo(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getSendList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getReceiveList(Map<String, Object> map) throws Exception;
	
}
