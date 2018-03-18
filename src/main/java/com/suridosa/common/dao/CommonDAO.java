package com.suridosa.common.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("commonDAO")
public class CommonDAO extends AbstractDAO{

	
	@SuppressWarnings("unchecked")
	public int  insertDocInfo(Map<String, Object> map) throws Exception{
		return insert("users.insertDocInfo", map);
	}

}
