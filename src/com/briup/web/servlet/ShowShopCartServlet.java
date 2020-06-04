package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.bean.User;
import com.briup.common.exception.ProductException;
import com.briup.common.exception.UserException;
import com.briup.dao.impl.ShopCartItemDaoImpl;
import com.briup.service.impl.ProductServiceImpl;
import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.service.impl.UserServiceImpl;
import com.briup.web.view.ShopItemInfo;



/**
 * Servlet implementation class ShowShopCartServlet
 */
@WebServlet("/user/showShopCartServlet")
public class ShowShopCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user1 = (User) request.getSession().getAttribute("loginUser");
		User user = null;
		try {
			user=userServiceImpl.getUserByName(user1.getUsername());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		List<ShopItemInfo> listItemByUserId = shopCartItemServiceImpl.listItemByUserId(user.getId());
		request.getSession().setAttribute("shopItemInfos", listItemByUserId);
		response.sendRedirect("shopCart.jsp");
		
		
	}

}
