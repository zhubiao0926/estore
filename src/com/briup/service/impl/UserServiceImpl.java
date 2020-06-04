package com.briup.service.impl;

import java.util.List;

import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.dao.impl.UserDaoImpl;
import com.briup.service.IUserService;


public class UserServiceImpl implements IUserService{
	private UserDaoImpl userDaoImpl=new UserDaoImpl();
	/**
	 * 注册
	 * */
	@Override
	public void registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		String sql="insert into s_user VALUES(my_seq.nextval,?,?,?,?,?,?,?)";
		userDaoImpl.executeUpdate(sql,new Object[] {user.getUsername(),user.getPassword(),user.getZip(),user.getAddress(),user.getPhone(),user.getEmail(),user.getDob()});
	}
	/**
	 * 登陆
	 * */
	@Override
	public User loginUser(String name, String password) throws UserException {
		// TODO Auto-generated method stub
		String sql2="select * from s_user where username= ? and password= ?";
	/*	User user=new User();*/
		 List<User> users = userDaoImpl.find(sql2, new Object[] {name,password}, User.class);
		/* for (int i = 0; i < users.size(); i++) {
	           user=users.get(i);
	            }*/
		 if (users.size()>0) {
			return users.get(0);
		}else {
			throw new UserException("用户名或密码错误");
		}
	}
	/**
	 * 用户名唯一验证
	 * */
	@Override
	public User getUserByName(String name) throws UserException {
		// TODO Auto-generated method stub
		String sql2="select * from s_user where username= ?";
	/*	User user=new User();*/
		 List<User> users = userDaoImpl.find(sql2, new Object[] {name}, User.class);
		 if(users.size()>0){
			return users.get(0);
		 }
		 return null;
		 /*for (int i = 0; i < users.size(); i++) {
	           user=users.get(i);
	            }
		return user;*/
	}

	@Override
	public void updateUserInfo(User user) throws UserException {
		// TODO Auto-generated method stub
		String sql = "update s_user set password=? where username=?";
		userDaoImpl.executeUpdate(sql, new Object[] {user.getPassword(),user.getUsername()});
	}

}
