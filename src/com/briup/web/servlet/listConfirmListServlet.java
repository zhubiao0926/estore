package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.briup.bean.User;
import com.briup.common.exception.OrderException;
import com.briup.common.exception.UserException;
import com.briup.service.impl.OrderServiceImpl;
import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.service.impl.UserServiceImpl;
import com.briup.web.view.OrderShopInfo;
import com.briup.web.view.ShopItemInfo;

/**
 * Servlet implementation class listConfirmListServlet
 */
@WebServlet("/user/listConfirmListServlet")
public class listConfirmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listConfirmListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		System.out.println(user.getId());
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		try {
			Map<String, List<OrderShopInfo>> listAllOrder = orderServiceImpl.listAllOrder(user.getId());
			request.getSession().setAttribute("orderList", listAllOrder);
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("confirmList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
