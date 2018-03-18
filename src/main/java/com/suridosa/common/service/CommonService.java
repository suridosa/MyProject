package com.suridosa.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommonService {
	
	int  insertDocInfo(Map<String, Object> map ) throws Exception;	
	
}
