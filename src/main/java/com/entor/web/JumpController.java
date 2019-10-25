package com.entor.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.entor.entity.Document;
import com.entor.entity.Role;
import com.entor.entity.User;
import com.entor.entity.UserRole;
import com.entor.service.IClassificationService;
import com.entor.service.IDocumentService;
import com.entor.service.IRoleService;
import com.entor.service.IUserRoleServate;
import com.entor.service.IUserService;
import com.github.pagehelper.PageInfo;


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
	
	
	private int pageSize = 5;
	
	@RequestMapping("/index")
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
		map.put("use", 0);
		return "index";
	}
	
	
	@RequestMapping("/my")
	public String my(Map<String, Object> map,Integer pageNum) {
		if(pageNum == null || pageNum == 0) {
			pageNum = 1;
		}
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
		Wrapper dwrapper = new EntityWrapper<Document>();
		dwrapper.eq("uid", user.getId());
		List<Document> ds = documentService.selectList(dwrapper);
		map.put("ds", ds);
		map.put("cont",line/1024);
		map.put("name", name);
		map.put("use", 0);
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
		map.put("use", 0);
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
		Wrapper ewrapper = new EntityWrapper<Document>();
		ewrapper.eq("uid", user.getId());
		ewrapper.eq("cid", 3);
		List<Document> ws = documentService.selectList(ewrapper);
		map.put("ws", ws);
		map.put("cont",line/1024);
		map.put("name", name);
		map.put("use", 0);
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
		Wrapper ewrapper = new EntityWrapper<Document>();
		ewrapper.eq("uid", user.getId());
		ewrapper.eq("cid", 1);
		List<Document> es = documentService.selectList(ewrapper);
		map.put("es", es);
		map.put("cont",line/1024);
		map.put("name", name);
		map.put("use", 0);
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
		Wrapper pwrapper = new EntityWrapper<Document>();
		pwrapper.eq("uid", user.getId());
		pwrapper.eq("cid", 2);
		List<Document> ps = documentService.selectList(pwrapper);
		map.put("ps", ps);
		map.put("cont",line/1024);
		map.put("name", name);
		map.put("use", 0);
		return "ppt";
	}
	
	@RequestMapping("/addDocument")
	public String addDocument(Map<String, Object> map) {
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
		map.put("use", 0);
		return "addDocument";
	}
}
