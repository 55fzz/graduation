package com.entor.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.entor.entity.UserRole;
import com.entor.mapper.UserRoleMapper;
import com.entor.service.IUserRoleServate;

@Service
public class UserRoleServateImpl extends ServiceImpl<UserRoleMapper,UserRole>  implements IUserRoleServate{

}
