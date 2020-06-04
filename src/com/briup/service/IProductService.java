package com.briup.service;

import java.util.List;
import java.util.Set;

import com.briup.bean.Product;
import com.briup.common.exception.ProductException;


public interface IProductService {
	/**
	 * 获取所有商品
	 * */
	public List<Product> listAllProduct();
	/**
	 * 根据商品ID获取商品
	 * */
	public Product selectProductById(long productId) throws ProductException;
	/**
	 * 获取热卖商品
	 * */
	public List<Product> listHostProducet() throws ProductException;
	
	/**
	 * 根据一级菜单ID获取商品
	 * */
	public List<Product> listProductByCategoryId(long id) throws ProductException;
	/**
	 * 根据二级菜单ID获取商品
	 * */
	public List<Product> listProductByCategoryDetailId(long id) throws ProductException;
	/**
	 * 获取出版社信息
	 * */
	public Set<String> listPublish() throws ProductException;
	/**
	 * 根据商品ID获取商品信息
	 * */
	public Product getProductById(long id) throws ProductException;
	/**
	 * 根据商品ID获取类别信息
	 * */
	public List<String> getCateInfoByProductId(long id)  throws ProductException;
	/**
	 * 根据商品名字keyword获取商品信息
	 * */
	public List<Product> listProductBykeyword(String keyword)  throws ProductException;
}