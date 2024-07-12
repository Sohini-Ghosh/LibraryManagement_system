package com.nagarro.controllers;
import javax.servlet.http.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.dto.Book;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;

import java.util.List;

@Controller
public class LoginController {
	@Autowired
	private UserService us;
	@Autowired
	private BookService bs;

	@RequestMapping("/LogIn")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			String uname = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			System.out.println("login check");
			HttpSession httpSession = request.getSession();
			if (us.checkUser(uname, pwd)) {
				System.out.println("login successfull");
				mv.setViewName("libraryhome");
				httpSession.setAttribute("user", uname);
				httpSession.setAttribute("msg", "User logged in successfully");
				return new ModelAndView("redirect:/library");
			}else{
				httpSession.setAttribute("msg", "Invalid credentials!! Please Try To Login Again!!");
				mv.setViewName("index");
			}
		}catch(Exception e) {
			mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping("/SignUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		User user=new User(userName,pwd);
		us.saveUser(user);
		System.out.println("Registration successful");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/LogOut")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession=request.getSession();
		httpSession.removeAttribute("user");
		ModelAndView mv = new ModelAndView();
		httpSession.setAttribute("msg", "User logged out successfully");
		mv.setViewName("index");
		return mv;
	}

}