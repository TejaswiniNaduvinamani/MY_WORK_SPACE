package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	private LoginService loginService;
	
	
	public LoginController(@Autowired @Qualifier(value="login") LoginService login) {
		System.out.println("Creating service object");
		loginService = login;
	}
	
	@RequestMapping("login")
	public ModelAndView validateLogin(@RequestParam("user") String userName, 
			@RequestParam("password") String password){
		
		return loginService.validateLogin(userName, password);
		
	}

}
