package com.entor.service;

import com.entor.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-10-12
 */
public interface IUserService extends IService<User> {
	
	
	public User login(String username ,String password);
}
