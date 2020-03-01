package com.demo.controller;

	import org.springframework.beans.factory.DisposableBean;
	import org.springframework.beans.factory.InitializingBean;
	import org.springframework.stereotype.Service;
	import org.springframework.web.servlet.ModelAndView;
	import javax.annotation.* ;

	@Service("login")
	public class LoginService  {
		
		
		public boolean validateLogin(String userName, String password){
			if(userName.equalsIgnoreCase("tejaswini") && password.equals("1234")){
				return true;			
			}
				return false;
		}

	}



