package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.service.impl.UserServiceImpl;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		try {
			User loginUser = userServiceImpl.loginUser(username, password);
			if (loginUser!=null) {
				User user=new User();
				user.setUsername(username);
				user.setPassword(password);
				request.getSession().setAttribute("loginUser", user);
				response.sendRedirect("/estore/index.jsp");
			/*	request.getRequestDispatcher("/index.jsp").forward(request,response);*/
			}
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//登录失败
			response.sendRedirect("/estore/login.jsp");
		}
	}
}

