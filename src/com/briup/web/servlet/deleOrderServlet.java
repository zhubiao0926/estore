package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.common.exception.OrderException;
import com.briup.service.impl.OrderLineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class deleOrderServlet
 */
@WebServlet("/user/deleOrderServlet")
public class deleOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		long parseLong = Long.parseLong(orderid);
		
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		try {
			Order findOrderByOrderNums = orderServiceImpl.findOrderByOrderNums(orderid);
			orderServiceImpl.delOrder(findOrderByOrderNums.getId());
		} catch (OrderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		OrderLineServiceImpl orderLineServiceImpl = new OrderLineServiceImpl();
		try {
			orderLineServiceImpl.delOrder(parseLong);
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
