package com.briup.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.ant.FindLeaksTask;

import com.briup.bean.Order;
import com.briup.common.exception.OrderException;
import com.briup.dao.impl.OrderDaoImpl;
import com.briup.service.IOrderService;
import com.briup.web.view.OrderShopInfo;

public class OrderServiceImpl implements IOrderService{
       OrderDaoImpl orderdaoimpl= new OrderDaoImpl();
	@Override
	public void saveOrder(Order order) throws OrderException {
		// TODO Auto-generated method stub
		String sql = "insert into s_order values(my_seq.nextval,?,1,?,?,?,?,?,?)";
		System.out.println(order.getUser().getId());
		orderdaoimpl.executeUpdate(sql, new Object[] {order.getOrderid(),order.getReceivename(),order.getReceiveaddress(),order.getReceivephone(),order.getSum(),order.getDob(),order.getUser().getId()});
		
	}

	@Override
	public void delOrder(Long orderid) throws OrderException {
		String sql="delete from s_order where id=?";
		orderdaoimpl.executeUpdate(sql, new Object[] {orderid});
		
	}

	@Override
	public Map<String, List<OrderShopInfo>> listAllOrder(Long customerid) throws OrderException {
String sql="select * from s_order,product,orderline where product.id=orderline.product_id and orderline.order_id=s_order.id and user_id=?";
		List<OrderShopInfo> list = orderdaoimpl.find(sql, new Object[] {customerid}, OrderShopInfo.class);
		Map<String,List<OrderShopInfo>> map = new HashMap<String,List<OrderShopInfo>>();
            for(OrderShopInfo os : list) {
            	String sql2="select * from s_order,product,orderline where product.id=orderline.product_id and orderline.order_id=s_order.id and orderid=?";
            	List<OrderShopInfo> list2 = orderdaoimpl.find(sql2, new Object[] {os.getOrderid()}, OrderShopInfo.class);
	        map.put(os.getOrderid(),list2);
		}
		return map;
		
		
		
	}

	@Override
	public Order findOrderById(Long orderid) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderByOrderNums(String orderNums) throws OrderException {
		// TODO Auto-generated method stub
		String sql = "select * from s_order where orderid=?";
		List<Order> find = orderdaoimpl.find(sql, new Object[] {orderNums}, Order.class);
		Order order = find.get(0);
		return order;
	}

}
