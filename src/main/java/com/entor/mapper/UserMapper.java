package com.entor.mapper;

import com.entor.entity.User;

import javax.annotation.ManagedBean;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-10-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}