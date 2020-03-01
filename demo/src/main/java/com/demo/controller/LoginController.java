package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
@RequestMapping(value="/rest")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping(value="/login", params={"user", "password"}, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, Boolean>> validateLogin(@RequestParam("user") String userName, 
			@RequestParam("password") String password){
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("login", loginService.validateLogin(userName, password));
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
