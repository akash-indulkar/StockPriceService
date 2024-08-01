package com.akashxdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.akashxdev.dao.AdminDao;
import com.akashxdev.model.Admin;
import com.akashxdev.model.AdminPrincipal;

@Service
public class MyAdminDetailsService implements UserDetailsService{

	@Autowired
	private AdminDao adminDao;
	
	private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminDao.findByEmail(username);
		if(admin == null) {
			throw new UsernameNotFoundException("Admin 404");
		}
		return new AdminPrincipal(admin);
	}
	
	public ResponseEntity<String> add(Admin admin)  {
		admin.setPassword(encoder.encode(admin.getPassword()));
		adminDao.save(admin);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
