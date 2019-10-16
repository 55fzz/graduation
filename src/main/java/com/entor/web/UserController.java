package com.entor.web;


import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entor.entity.User;
import com.entor.mapper.UserMapper;
import com.entor.service.IClassificationService;
import com.entor.service.IDocumentService;
import com.entor.service.IRoleService;
import com.entor.service.IUserRoleServate;
import com.entor.service.IUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2019-10-14
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IDocumentService  documentService;
	@Autowired
	private IClassificationService classificationService;
	@Autowired
	private IUserRoleServate userRoleServate;
	
	
	
	
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
			return "redirect:/index";
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
		File file=new File("src\\main\\resources\\document\\"+name);
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
		return "redirect:/user/login";
	}
	
	
	@RequestMapping("/addForm")
	public String addForm() {
		return "addForm";
	}
	
	
	

}
