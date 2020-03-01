package com.demo.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.* ;

@Service("login")
public class LoginService  {
	
	
	public ModelAndView validateLogin(String userName, String password){
		
		ModelAndView mv = new ModelAndView();
		
		if(userName.equalsIgnoreCase("tejaswini") && password.equals("1234")){
			mv.setViewName("login");			
		}
		else{
			mv.setViewName("index");
		}
		
		return mv;
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("by Annotation Pre destroy call");
		
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("by annotation Post initializer");
	}

}
