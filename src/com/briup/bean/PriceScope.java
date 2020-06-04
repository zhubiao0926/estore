package com.briup.bean;
/**
 * 价格大小分段的类
 * @author briup
 */
public class PriceScope {
	private long id;
	/*定格区间的最小值*/
	private long min;
	/*定格区间的最大值*/
	private long max;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMin() {
		return min;
	}
	public void setMin(long min) {
		this.min = min;
	}
	public long getMax() {
		return max;
	}
	public void setMax(long max) {
		this.max = max;
	}
}
