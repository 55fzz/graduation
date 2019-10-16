package com.entor.web;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entor.entity.Role;
import com.entor.entity.User;
import com.entor.entity.Document;
import com.entor.entity.UserRole;
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
 * @since 2019-10-16
 */
@Controller
@RequestMapping("/document")
public class DocumentController {
	
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
	
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("name") String dname,@RequestParam("file") MultipartFile file,Map<String, Object> map) {
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
		if (file.isEmpty()|| (int)file.getSize()==0) {
	           return "上传失败，请选择文件";
	    }
		File foler=new File("src\\main\\resources\\document\\"+name);
		if(!foler.exists()){//如果文件夹不存在
			foler.mkdir();//创建文件夹
		}
		String filePath = "src\\main\\resources\\document\\"+name; 
		String fileName = file.getOriginalFilename();
		String Tail = fileName.substring(fileName.lastIndexOf("."));
		File dest = new File( new File("src\\main\\resources\\document\\"+name).getAbsolutePath()+"\\" + dname+Tail);
		try {
			file.transferTo(dest);
			Document document = new Document();
			document.setSize(String.valueOf(file.getSize()));
			document.setTitle(dname);
			if(Tail.equals(".doc")||Tail.equals(".dock")) {
				document.setCid(2);
			}else if(Tail.equals(".ppt")||Tail.equals(".pptx")) {
				document.setCid(1);
			}else {
				document.setCid(3);
			}
			document.setAddress(filePath + dname+Tail);
			document.setUid(user.getId());
			Date now = new Date();
			document.setCreateDate(now);
			documentService.insert(document);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("cont",line/1024);
		map.put("name", name);
		map.put("use", 0);
		return "redirect:/index";
	}
}
