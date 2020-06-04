package com.briup.bean;

import java.util.Set;
/**
 * 书的小分类
 * @author briup
 *
 */
public class CategoryDetail {
	private long id;
	/*书小分类的名字*/
	private String name;
	/*书所属于的大的类型*/
	private Category cate;
	/*单前类型对应的所有产品*/
	private Set<Product> products;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
