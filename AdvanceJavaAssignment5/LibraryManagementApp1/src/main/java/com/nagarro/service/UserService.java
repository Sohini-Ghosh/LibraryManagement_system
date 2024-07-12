package com.nagarro.service;

import com.nagarro.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public void saveUser(User user);
	public boolean checkUser(String uname, String pwd);
}
