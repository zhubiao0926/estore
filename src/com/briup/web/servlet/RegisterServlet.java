package com.briup.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.service.impl.UserServiceImpl;




@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		//处理注册功能
		//1、获取用户名
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("name");
		try {
			User userByName = userServiceImpl.getUserByName(username);
		//2、判断用户名是否可用
       /* if ( userByName.getUsername()!=null||"".equals(username)) {*/
			if ( userByName!=null||"".equals(username)) {
        	//如果不可用，重定向到注册页面，重新注册
				response.sendRedirect("/estore/register.jsp");
        	/*request.getRequestDispatcher("/register.jsp").forward(request,response);*/
		}else {
			//如果可用，再获取其他注册信息，进行注册操作
			String password=request.getParameter("password");
			String zip=request.getParameter("zip");
			String address=request.getParameter("address");
			String phone=request.getParameter("telephone");
			String email=request.getParameter("email"); 
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			//将获取的所有注册信息封装成user对象
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setZip(zip);
			user.setAddress(address);
			user.setPhone(phone);
			user.setEmail(email);
			user.setDob(date);
			//调用sercice层业务逻辑，将用户信息持久化到数据库
				userServiceImpl.registerUser(user);
				//注册成功，重定向到登录页面
				   //如果不用重定向会有什么问题
				response.sendRedirect("/estore/login.jsp");
				/*request.getRequestDispatcher("/login.jsp").forward(request,response);*/
			} 
		}catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//如果有异常，也会注册失败
				response.sendRedirect("/estore/register.jsp");
			}
		
		
	
	}
}
