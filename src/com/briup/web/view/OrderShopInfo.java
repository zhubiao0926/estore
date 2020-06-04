package com.briup.web.view;

public class OrderShopInfo {
	private String orderid;
	private int paystatus;
	private int num;
	private String name;
	/*书的价钱*/
	private double price;
	/*书的图片 eg:大图1,大图2#小图1,小图2*/
	private String img;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "OrderShopInfo [orderid=" + orderid + ", paystatus=" + paystatus + ", num=" + num + ", name=" + name
				+ ", price=" + price + ", img=" + img + "]";
	}
	
	
}
