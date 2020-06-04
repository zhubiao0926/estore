package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.common.exception.ProductException;
import com.briup.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ShowShopCartServlet
 */
@WebServlet("/ShowProduct")
public class ShowProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		long l = Long.parseLong(id);
		ProductServiceImpl productServiceImpl=new ProductServiceImpl();
		try {
			Product product=productServiceImpl.getProductById(l);
			request.setAttribute("productInfo", product);
			request.getRequestDispatcher("/viewBook.jsp").forward(request, response);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
