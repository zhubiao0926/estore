package com.briup.service;

import java.util.List;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.common.exception.OrderException;
import com.briup.web.view.ShopItemInfo;

public interface IOrderLineService {
	/**
	 * 保存订单明细
	 * */
	public void saveOrder(OrderLine order) throws OrderException;
	/**
	 * 根据提交的商品保存订单明细
	 * */
	public void saveOrder(List<ShopItemInfo> list,Order order) throws OrderException;
	/**
	 * 根据ID删除订单明细
	 * */
	public void delOrder(Long orderid) throws OrderException;

}