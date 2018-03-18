package com.suridosa.myapp.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.suridosa.common.dao.AbstractDAO;

@Repository("worktimeDAO")
public class MyWorktimeDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSwonInfo(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("worktime.selectSawonInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public int regStart(Map<String, Object> map) throws Exception{
		return insert("worktime.regStart", map);
	}
	
	@SuppressWarnings("unchecked")
	public int regEnd(Map<String, Object> map) throws Exception{
		return update("worktime.regEnd", map);
	}

}
