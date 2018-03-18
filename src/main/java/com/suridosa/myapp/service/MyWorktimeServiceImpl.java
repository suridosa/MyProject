package com.suridosa.myapp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.suridosa.myapp.dao.MyWorktimeDAO;

@Service("worktimeService")
public class MyWorktimeServiceImpl implements	MyWorktimeService {

	private static final Logger logger = LoggerFactory.getLogger(MyWorktimeServiceImpl.class);	
	
	@Resource(name="worktimeDAO")
	private MyWorktimeDAO worktimeDAO;	

	@Override
	public List<Map<String, Object>> getSawonInfo(Map<String, Object> map) throws Exception {
		return worktimeDAO.getSwonInfo(map);
	}

	@Override
	public int regStart(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return worktimeDAO.regStart(map);
	}

	@Override
	public int regEnd(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return worktimeDAO.regEnd(map);
	}
	
	 
}
