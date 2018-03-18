package com.suridosa.common.service;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.suridosa.common.dao.CommonDAO;

@Service("commonService")
public class CommonServiceImpl implements	CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);	
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;	

	@Override
	public int insertDocInfo(Map<String, Object> map) throws Exception {
		return commonDAO.insertDocInfo(map);
	}
	
	
}
