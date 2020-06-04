package com.briup.bean;

import java.util.Date;
import java.util.Set;

/**
 * 用户表
 * @author briup
 */
public class User {
	private long id;
	/*用户名*/
	private String username;
	/*密码*/
	private String password;
	/*邮编*/
	private String zip;
	/*地址值*/
	private String address;
	/*电话号码*/
	private String phone;
	/*邮件*/
	private String email;
	/*注册时间*/
	private Date dob;
	
	/*用户所拥有的订单*/
	private Set<Order> orders;
	/*用户加入到购物车的所有商品项*/
	private Set<ShopCartItem> cartItem;
	/*用户关注的降价通知商品项*/
	private Set<Reduce> reduces;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Set<ShopCartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(Set<ShopCartItem> cartItem) {
		this.cartItem = cartItem;
	}
	public Set<Reduce> getReduces() {
		return reduces;
	}
	public void setReduces(Set<Reduce> reduces) {
		this.reduces = reduces;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", dob=" + dob + ", orders=" + orders
				+ ", cartItem=" + cartItem + ", reduces=" + reduces + "]";
	}
	
}
