package com.suridosa.callpopup.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.suridosa.common.dao.AbstractDAO;

@Repository("callpopupDAO")
public class CallpopupDAO extends AbstractDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CallpopupDAO.class);	

	@SuppressWarnings("unchecked")
	public int regUserInfo(Map<String, Object> map) throws Exception{
		return update("callpop.regUserInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCallLocation(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("callpop.getCallLocation", map);
	}
	
	@SuppressWarnings("unchecked")
	public int regMyLocation(Map<String, Object> map) throws Exception{
		return update("callpop.regMyLocation", map);
	}
	
	@SuppressWarnings("unchecked")
	public int regSendInfo(Map<String, Object> map) throws Exception{
		return update("callpop.regSendInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSendList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("callpop.getSendList", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getReceiveList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("callpop.getReceiveList", map);
	}
	
}
