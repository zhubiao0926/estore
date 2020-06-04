package com.briup.bean;
/**
 * 购物车订单项详情
 * @author briup
 *
 */
public class ShopCartItem {
	private long id;
	/*购物车订单项所属用户*/
	private User user;
	/*购物车订单项包含的产品*/
	private Product product;
	/*购物车订单项购买的数量*/
	private int num;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
