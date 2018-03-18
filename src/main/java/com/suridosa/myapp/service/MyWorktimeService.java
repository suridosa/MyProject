package com.suridosa.myapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MyWorktimeService {
	
	List<Map<String, Object>>  getSawonInfo(Map<String, Object> map ) throws Exception;

	int  regStart(Map<String, Object> map ) throws Exception;	

	int  regEnd(Map<String, Object> map ) throws Exception;	
	

}
