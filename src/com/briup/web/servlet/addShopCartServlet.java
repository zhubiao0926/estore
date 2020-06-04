package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.bean.ShopCart;
import com.briup.bean.ShopCartItem;
import com.briup.bean.User;
import com.briup.common.exception.ProductException;
import com.briup.service.impl.ProductServiceImpl;
import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.service.impl.UserServiceImpl;

/**
 * Servlet implementation class addShopCartServlet
 */
@WebServlet("/user/addShopCartServlet")
public class addShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		long productId = Integer.decode(request.getParameter("productId"));
		Integer productNum = Integer.decode(request.getParameter("productNum"));
		User user1 = (User) request.getSession().getAttribute("loginUser");
		Product product = null;
		User user = null;
		try {
			product =productServiceImpl.getProductById(productId);
			user=userServiceImpl.getUserByName(user1.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().print("加购失败");
		}
		ShopCartItem shopCartItem = new ShopCartItem();
		shopCartItem.setUser(user);
		shopCartItem.setNum(productNum);
		shopCartItem.setProduct(product);
		
		shopCartItemServiceImpl.saveShopCartItem(shopCartItem);
		response.getWriter().print("加购成功");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
