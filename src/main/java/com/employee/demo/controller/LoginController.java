package com.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.demo.pojo.User;
import com.employee.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login.jsp";
	}

	@RequestMapping(value = "processUser.html", method = RequestMethod.POST)
	public String processUser(Model model, @ModelAttribute("user") User user) {

		loginService.saveUser(user);

		List<User> userList = loginService.getUserList();

		model.addAttribute("userList", userList);

		model.addAttribute("user", new User());

		return "dashboard.jsp";

	}

}
