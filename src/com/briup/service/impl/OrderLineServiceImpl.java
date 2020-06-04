package com.briup.service.impl;

import java.util.List;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.Product;
import com.briup.common.exception.OrderException;
import com.briup.dao.impl.OrderDaoImpl;
import com.briup.service.IOrderLineService;
import com.briup.web.view.ShopItemInfo;

public class OrderLineServiceImpl implements IOrderLineService{
	 OrderDaoImpl orderdaoimpl= new OrderDaoImpl();
	 OrderServiceImpl  OrderServiceImpl = new OrderServiceImpl();
	 ShopCartItemServiceImpl  ShopCartItemServiceImpl = new ShopCartItemServiceImpl();
	@Override
	public void saveOrder(OrderLine order) throws OrderException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrder(List<ShopItemInfo> list, Order order) throws OrderException {
		// TODO Auto-generated method stub
		String sql = "insert into orderline values(my_seq.nextval,?,?,?)";
		String sql2 = "select * from product where name=?";
		for(ShopItemInfo shops:list) {
		String name = shops.getName();
		int num = shops.getNum();
		long id = shops.getId();
		List<Product> list2 = orderdaoimpl.find(sql2, new Object[] {name}, Product.class);
		Product product = list2.get(0);
		Order findOrderByOrderNums = OrderServiceImpl.findOrderByOrderNums(order.getOrderid());
		System.out.println(name);
		System.out.println(num);
		System.out.println(findOrderByOrderNums.getId());
		System.out.println(product.getId());
		orderdaoimpl.executeUpdate(sql, new Object[] {num,findOrderByOrderNums.getId(),product.getId()});
		ShopCartItemServiceImpl.deleteShopCartItem(id);
		}
		
		
	}

	@Override
	public void delOrder(Long orderid) throws OrderException {
		// TODO Auto-generated method stub
		String sql="delete from orderline where order_id=?";
		orderdaoimpl.executeUpdate(sql, new Object[] {orderid});
	}

}
