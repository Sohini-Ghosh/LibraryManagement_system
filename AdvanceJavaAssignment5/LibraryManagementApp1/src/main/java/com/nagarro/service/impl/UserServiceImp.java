package com.nagarro.service.impl;

import com.nagarro.dto.User;
import com.nagarro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Component
public class UserServiceImp implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	private String url = "http://localhost:8989/users/";
	public void saveUser(User user) {
		restTemplate.postForEntity(url,user,User.class);
	}
	public boolean checkUser(String uname, String pwd) {
		User user = (User)restTemplate.getForObject((url+uname),User.class);
		return user != null && bCryptPasswordEncoder.matches(pwd,user.getPassword());
	}

}
