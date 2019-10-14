package com.entor.service;

import com.entor.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-10-14
 */
public interface IUserService extends IService<User> {
	
	public User login(String name,String password);
}
