package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Order;
import com.briup.common.exception.OrderException;
import com.briup.web.view.OrderShopInfo;



public interface IOrderService {
	/**
	 * 保存订单
	 * */
	public void saveOrder(Order order) throws OrderException;
	/**
	 * 删除订单
	 * */
	public void delOrder(Long orderid) throws OrderException;
	
	/**
	 * 查找用户所有订单
	 * */
	public Map<String,List<OrderShopInfo>> listAllOrder(Long customerid) throws OrderException;
	
	/**
	 * 查找单个订单
	 * */
	public Order findOrderById(Long orderid) throws OrderException;
	/**
	 * 根据订单编号查找单个订单
	 * */
	public Order findOrderByOrderNums(String orderNums) throws OrderException;
}