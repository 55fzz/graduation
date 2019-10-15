package com.entor.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entor.entity.Role;
import com.entor.entity.User;
import com.entor.entity.UserRole;
import com.entor.service.IClassificationService;
import com.entor.service.IDocumentService;
import com.entor.service.IRoleService;
import com.entor.service.IUserRoleServate;
import com.entor.service.IUserService;


@Controller
public class JumpController {

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
	
	
	@RequestMapping("index")
	public String index(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "index";
	}
	
	
	@RequestMapping("/my")
	public String my(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "my";
	}
	
	@RequestMapping("/zuijin")
	public String zuijin(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "zuijin";
	}
	
	
	@RequestMapping("/word")
	public String word(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "word";
	}
	
	@RequestMapping("/excel")
	public String excel(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "excel";
	}
	
	@RequestMapping("/ppt")
	public String ppt(Map<String, Object> map) {
		Subject subject = SecurityUtils.getSubject();
		String name = subject.getPrincipals().toString();
		Wrapper wrapper = new EntityWrapper<User>();
		wrapper.eq("name", name);
		User user = (User) userService.selectOne(wrapper);
		Wrapper urwrapper = new EntityWrapper<UserRole>();
		urwrapper.eq("uid", user.getId());
		UserRole userRole = userRoleServate.selectOne(urwrapper);
		Wrapper rwrapper = new EntityWrapper<Role>();
		rwrapper.eq("id", userRole.getRid());
		Role role = roleService.selectOne(rwrapper);
		int line = Integer.parseInt(role.getLine());
		map.put("cont",line/1024);
		map.put("name", name);
		return "ppt";
	}
}
