package com.briup.bean;

import java.util.Set;
/**
 * 产品
 * @author briup
 *
 */
public class Product {
	private long id;
	/*书的名字*/
	private String name;
	/*书的价钱*/
	private double price;
	/*书的出版社*/
	private String publish;
	/*书的图片 eg:大图#小图*/
	private String img;
	/*书的规格参数*/
	private String parameter;
	/*书的介绍*/
	private String introduction;
	/*书的清单*/
	private String wrapist;
	/*书的状态，1热卖：每中类型最多4本热卖书籍，0为非热卖*/
	private int hot;
	/*书的库存*/
	private int remain;
	/*书的销量*/
	private int sellnum;
	/*书的点击率*/
	private int clickrate;
	/*书的上架时间,毫秒数*/
	private long publishdate;
	/*书从属的购物项*/
	private Set<ShopCartItem> cartItems;
	/*书的降价项*/
	private Set<Reduce> reduces;
	/*书的分类*/
	private CategoryDetail cate_detail;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWrapist() {
		return wrapist;
	}
	public void setWrapist(String wrapist) {
		this.wrapist = wrapist;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public int getSellnum() {
		return sellnum;
	}
	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}
	public int getClickrate() {
		return clickrate;
	}
	public void setClickrate(int clickrate) {
		this.clickrate = clickrate;
	}
	public long getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(long publishdate) {
		this.publishdate = publishdate;
	}
	public CategoryDetail getCate_detail() {
		return cate_detail;
	}
	public void setCate_detail(CategoryDetail cate_detail) {
		this.cate_detail = cate_detail;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", publish=" + publish + ", img=" + img
				+ ", parameter=" + parameter + ", introduction=" + introduction + ", wrapist=" + wrapist + ", hot="
				+ hot + ", remain=" + remain + ", sellnum=" + sellnum + ", clickrate=" + clickrate + ", publishdate="
				+ publishdate + ", cartItems=" + cartItems + ", reduces=" + reduces + ", cate_detail=" + cate_detail
				+ "]";
	}
	
}
