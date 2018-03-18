package com.suridosa.callpopup.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.suridosa.callpopup.dao.CallpopupDAO;

@Service("callpopupService")
public class CallpopupServiceImpl implements CallpopupService {
	
	private static final Logger logger = LoggerFactory.getLogger(CallpopupServiceImpl.class);	
	
	@Resource(name="callpopupDAO")
	private CallpopupDAO callpopupDAO;	

	@Override
	public int regUserInfo(Map<String, Object> map) throws Exception {
		
		return callpopupDAO.regUserInfo(map);
	}
	
	@Override
	public List<Map<String, Object>> getCallLocation(Map<String, Object> map) throws Exception {
		
		return callpopupDAO.getCallLocation(map);
	}

	@Override
	public int regMyLocation(Map<String, Object> map) throws Exception {

		return callpopupDAO.regMyLocation(map);
	}
	
	@Override
	public int regSendInfo(Map<String, Object> map) throws Exception {
		
		return callpopupDAO.regSendInfo(map);
	}
	
	@Override
	public List<Map<String, Object>> getSendList(Map<String, Object> map) throws Exception {
		
		return callpopupDAO.getSendList(map);
	}
	
	@Override
	public List<Map<String, Object>> getReceiveList(Map<String, Object> map) throws Exception {
		
		return callpopupDAO.getReceiveList(map);
	}

}
