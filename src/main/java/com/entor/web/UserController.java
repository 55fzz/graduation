package com.entor.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.User;
import com.entor.service.IUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2019-10-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(String name,String password) {
		SimpleHash hash = new SimpleHash("md5",password,"@vafd-*",2);
		UsernamePasswordToken token = new UsernamePasswordToken(name, hash.toHex());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/user/index";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/user/login";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logou() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/user/login";
	}
	
	@RequestMapping("/add")
	public String add(String name,String password) {
		SimpleHash hash = new SimpleHash("md5",password,"@vafd-*",2);
		String md5Password = hash.toHex();
		User user = new User();
		user.setName(name);
		user.setPassword(md5Password);
		userService.insert(user);
		return "redirect:/user/login";
	}
}
