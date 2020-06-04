package com.briup.bean;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShopCart implements IShopCart {
	/*
	 * orderlines存储加入到购物车中的产品，key为产品id，value为订单项（订单项中存在数量）
	 * 注意：购物车中产品登陆之后添加
	 * 购物车存储在session会话，每一个用户登陆到服务器，服务器都会为
	 * 每一个客户端分配一个session对象，session的有效时间30分钟
	 */
	private Map<Long,OrderLine> orderlines = new HashMap<Long,OrderLine>();
	
	/**
	 * 添加产品到购物车
	 */
	public void addProduct(Product product) throws Exception{
		int number = 1;
		long id = product.getId();
		if(orderlines.containsKey(id)) {
			OrderLine orderline = (OrderLine) orderlines.get(id);
			number = orderline.getNum()+1;
			orderline.setNum(number);
		}else {
			OrderLine orderline = new OrderLine();
			orderline.setNum(number);
			orderline.setProduct(product);
			orderlines.put(id, orderline);
		}
	}

	/**
	 * 移除购物车中的所有产品
	 */
	public void removeAllProducts() throws Exception{
		orderlines.clear();
	}

	/**
	 * 获取当前购物车中产品的总价格
	 */
	public BigDecimal getTotalPrice() throws Exception{
		BigDecimal totalPrice = new BigDecimal("0");
		Iterator<OrderLine> iter = getOrderlines();
		while(iter.hasNext()) {
			OrderLine o = iter.next();
			Product p = o.getProduct();
			//计算每一个订单项的价格，产品单价*数量
			//double类型精确计算最好采用BigDecimal类
			BigDecimal sum = new BigDecimal(p.getPrice()+"")
				.multiply(new BigDecimal(o.getNum()));
			totalPrice = totalPrice.add(sum);
		}
		return totalPrice;
	}

	/**
	 * 获取当前购物车中所有的订单项
	 */
	public Iterator<OrderLine> getOrderlines() throws Exception{
		return orderlines.values().iterator();
	}

	/**
	 * 根据产品id删除购物车中指定的订单项
	 */
	@Override
	public void removeProduct(Long productid) throws Exception {
		orderlines.remove(productid);
	}

	/**
	 * 更新购物车中订单项的数量
	 */
	@Override
	public void updateProduct(Long productid, Integer number) throws Exception {
		OrderLine orderline = orderlines.get(productid);
		if(orderline != null) {
			orderline.setNum(number);
		}
	}

	/**
	 * 获取当前购物车中订单项的数量
	 */
	@Override
	public int getShopCartSize() throws Exception {
		return orderlines.size();
	}
}
