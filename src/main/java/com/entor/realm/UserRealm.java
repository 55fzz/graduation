package com.entor.realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entor.entity.User;
import com.entor.service.IUserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private SessionDAO sessionDao;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		// 这里做权限控制
		return null;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//登录控制
		UsernamePasswordToken t = (UsernamePasswordToken)token;
		String username = t.getUsername();
		String password = new String(t.getPassword());
		User user = userService.login(username, password);
		if(user == null) {
			throw new AuthenticationException();
		}
		
		//清除当前用户已存在服务器的缓存,只允许一处登录
		//获取服务器当前所有的会话对象
		Collection<Session>  sessions = sessionDao.getActiveSessions();
		for (Session session : sessions) {
			//获取会话中的用户名
			String uname = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			if(uname.equals(username)) {
				//移除会话
				session.setTimeout(0);
				break;
			}
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,getName());
		return info;
	}
}

