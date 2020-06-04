package com.briup.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.ShopCart;
import com.briup.bean.User;
import com.briup.common.exception.OrderException;
import com.briup.common.exception.UserException;
import com.briup.service.impl.OrderLineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;
import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.service.impl.UserServiceImpl;
import com.briup.web.view.ShopItemInfo;

/**
 * Servlet implementation class confirmSubmitServlet
 */
@WebServlet("/user/confirmSubmitServlet")
public class confirmSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNums = request.getParameter("orderNums");
		String username = request.getParameter("username");	
		String phone = request.getParameter("phone");	
		String address	 = request.getParameter("address");	
		HttpSession session = request.getSession();
		List<ShopItemInfo>list= (List<ShopItemInfo>) session.getAttribute("shopItemInfoConfirms");
//		for(ShopItemInfo shops:list) {
//			long pid = shops.getId();
//			int num = shops.getNum();
//		}
		
		long price= (long) session.getAttribute("price");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user1 = (User) request.getSession().getAttribute("loginUser");
		User user = null;
		try {
			user=userServiceImpl.getUserByName(user1.getUsername());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order order =new Order();
//		OrderLine orderLine = new OrderLine();
		order.setOrderid(orderNums);
		order.setReceivename(username);
		order.setReceiveaddress(address);
		order.setReceivephone(phone);
		order.setSum(price);
		order.setUser(user);
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		order.setDob(date);
	    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	    OrderLineServiceImpl orderLineServiceImpl= new OrderLineServiceImpl();
	    
	    try {
			orderServiceImpl.saveOrder(order);
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			orderLineServiceImpl.saveOrder(list, order);
		} catch (OrderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
	    response.sendRedirect("confirmSuccess.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
