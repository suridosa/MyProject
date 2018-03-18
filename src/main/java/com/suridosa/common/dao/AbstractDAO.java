package com.suridosa.common.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
	
    @Autowired
    private SqlSessionTemplate sqlSession;
	

    public Object insert(String queryId, Object params){
        return sqlSession.insert(queryId, params);
    }
    
    public Object update(String queryId, Object params){
        return sqlSession.insert(queryId, params);
    }    
     
    public int insert(String queryId, Map<String, Object> params) {
    	return sqlSession.insert(queryId, params);    	
    }
    
    public int update(String queryId, Map<String, Object> params) {
        return sqlSession.update(queryId, params);
    }
     
    public int delete(String queryId, Map<String, Object> params) {
        return sqlSession.update(queryId, params);
    }
    
    public Object delete(String queryId, Object params){
        return sqlSession.delete(queryId, params);
    }
     
    public Object selectOne(String queryId){
         return sqlSession.selectOne(queryId);
    }
     
    public Object selectOne(String queryId, Object params){
        return sqlSession.selectOne(queryId, params);
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
        return sqlSession.selectList(queryId);
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
        return sqlSession.selectList(queryId,params);
    }   

    public Object selectListObj(String queryId, Object params){
        return sqlSession.selectList(queryId, params);
    }    
}
