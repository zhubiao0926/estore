package com.briup.service;

import com.briup.bean.User;
import com.briup.common.exception.UserException;


public interface IUserService {
	/**
	 * 注册
	 * */
	public void registerUser(User user) throws UserException;
	/**
	 * 登陆
	 * */
	public  User loginUser(String name,String password) throws UserException;
	/**
	 * 用户名唯一验证
	 * */
	public  User getUserByName(String name) throws UserException;
	/**
	 * 修改用户信息
	 * */
	public void updateUserInfo(User user) throws UserException;
	
}