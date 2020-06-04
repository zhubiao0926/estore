package com.briup.bean;

import java.util.Date;
/**
 * 简报
 * @author briup
 *
 */
public class Report {
	private long id;
	/*简报的名字*/
	private String name;
	/*简报的等级*/
	private int rank;
	/*简报的发布时间*/
	private Date publish_date;
	/*简报的部门*/
	private String department;
	/*简报的发布者*/
	private String publish_writer;
	/*简报的内容*/
	private String content;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPublish_writer() {
		return publish_writer;
	}
	public void setPublish_writer(String publish_writer) {
		this.publish_writer = publish_writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
