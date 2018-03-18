package com.suridosa.common.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suridosa.common.service.CommonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/common/fileUpload.do", method = RequestMethod.GET)
	public ModelAndView fileUpload(Map<String,Object> cmdmap)  throws Exception{
    	ModelAndView mv = new ModelAndView("/users/fileUpload");
    	
		return mv;
	}
	
	
}
