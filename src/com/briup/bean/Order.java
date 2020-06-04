package com.briup.bean;

import java.util.Date;
import java.util.Set;
/**
 * 订单
 * @author briup
 *
 */
public class Order {
	private long id;
	/*订单编号*/
	private String orderid;
	/*订单状态 1表示支付 2表示未支付*/
	private int paystatus;
	/*收货人姓名*/
	private String receivename;
	/*收获人地址*/
	private String receiveaddress;
	/*收货人电话号码*/
	private String receivephone;
	/*订单总价*/
	private double sum;
	/*订单生产的时间*/
	private Date dob;
	/*订单所属的用户*/
	private User user;
	/*订单项*/
	private Set<OrderLine> orderline;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getReceiveaddress() {
		return receiveaddress;
	}
	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}
	public String getReceivephone() {
		return receivephone;
	}
	public void setReceivephone(String receivephone) {
		this.receivephone = receivephone;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderLine> getOrderline() {
		return orderline;
	}
	public void setOrderline(Set<OrderLine> orderline) {
		this.orderline = orderline;
	}
	
}
