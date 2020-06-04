package com.briup.bean;
/**
 * 降价通知
 * @author briup
 *
 */
public class Reduce {
	private long id;
	/*降价所属的用户*/
	private User user;
	/*降价关注的产品*/
	private Product product;
	/*降价关注时的价钱*/
	private double baseprice;
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
	public double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}
}
