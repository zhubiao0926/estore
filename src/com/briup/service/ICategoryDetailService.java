package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Category;
import com.briup.bean.CategoryDetail;


public interface ICategoryDetailService {
	/**
	 * 获取所有的二级菜单
	 * */
	public Map<Category,List<CategoryDetail>> listCategoryDetail();
	/**
	 * 根据一级菜单的Id获取二级菜单
	 * */
	public List<CategoryDetail> getCategoryDetailsByCategoryId(long id);
	/**
	 * 保存二级菜单
	 * */
	public void saveCategoryDetail(CategoryDetail category);
	/**
	 * 删除二级菜单
	 * */
	public void delCategoryDetail(Long categoryDetailId);

}