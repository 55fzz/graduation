package com.entor.web;


import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2019-10-12
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(String username,String password) {
		SimpleHash hash = new SimpleHash("md5",password,"@vafd-*",2);
		UsernamePasswordToken token = new UsernamePasswordToken(username, hash.toHex());
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
	
	@RequestMapping("/index")
	public String index(Model model) {
		Subject subject = SecurityUtils.getSubject();
		String username = subject.getPrincipal().toString(); 
		model.addAttribute("username", username);
		return "index";
	}
	
	
	
	@RequestMapping("/addForm")
	public String addForm() {
		return "addForm";
	}
	
	
	@RequestMapping("/add")
	public String add(String username,String password) {
		SimpleHash hash = new SimpleHash("md5",password,"@vafd-*",2);
		String md5Password = hash.toHex();
		User user = new User();
		user.setUsername(username);
		user.setPassword(md5Password);
		userMapper.insert(user);
		return "redirect:/user/login";
	}
	
	
	
}
