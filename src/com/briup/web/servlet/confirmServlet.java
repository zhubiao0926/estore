package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.OrderLine;
import com.briup.bean.ShopCart;
import com.briup.bean.ShopCartItem;
import com.briup.utils.ProduceOrderNo;
import com.briup.web.view.ShopItemInfo;

import sun.security.util.Length;


/**
 * Servlet implementation class listConfirmListServlet
 */
@WebServlet("/user/confirmServlet")
public class confirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("shopInfoId");
		String[] arr = ids.substring(0, ids.length()-1).split("[,]");
		HttpSession session = request.getSession();
		List<ShopItemInfo>list= (List<ShopItemInfo>) session.getAttribute("shopItemInfos");
		List<ShopItemInfo>shops= new ArrayList<>();
		long price = 0;
		for(ShopItemInfo sh:list) {
			for(String id:arr) {
				if(sh.getId()==Long.parseLong(id)) {
					shops.add(sh);
					 price = (int) (price+sh.getPrice()*sh.getNum());
				}
			}
		}
		session.setAttribute("cartid", ids);
		String value=ProduceOrderNo.getOrderNo();
		session.setAttribute("orderNums", value);
		session.setAttribute("shopItemInfoConfirms",shops);
		session.setAttribute("price", price);
		response.sendRedirect("confirm.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
