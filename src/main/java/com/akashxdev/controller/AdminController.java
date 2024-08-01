package com.akashxdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akashxdev.service.JWTService;
import com.akashxdev.model.Admin;
import com.akashxdev.service.MyAdminDetailsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MyAdminDetailsService adminService;

	@Autowired
	private JWTService jwtService;

	@Autowired
	AuthenticationManager authManager;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody Admin admin){
		return adminService.add(admin);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin){
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
		if(auth.isAuthenticated()) {
			String token = jwtService.generateToken(admin.getEmail());
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Login Failed", HttpStatus.FORBIDDEN);
	}

}
