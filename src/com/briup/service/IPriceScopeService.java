package com.briup.service;

import java.util.List;

import com.briup.bean.PriceScope;


/**
 * 获取价格区间
 * */
public interface IPriceScopeService {

	/**
	 * 获取价格区间
	 * */
	public List<PriceScope> listAllPriceScope();
	/**
	 * 添加价格区间
	 * */
	public void addPriceScope(PriceScope priceScope);
	/**
	 * 删除价格区间
	 * */
	public void delPriceScope(Long priceScopeId);
}