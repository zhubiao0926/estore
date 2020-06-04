package com.briup.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.briup.bean.Category;
import com.briup.bean.CategoryDetail;
import com.briup.bean.Product;
import com.briup.dao.impl.CategoryDetailDaoImpl;
import com.briup.service.ICategoryDetailService;

public class CategoryDetailServiceImpl implements ICategoryDetailService{
private CategoryDetailDaoImpl detailDaoImpl=new CategoryDetailDaoImpl();
/*
 * 获取所有的一级分类和二级分类
 */
	@Override	public Map<Category, List<CategoryDetail>> listCategoryDetail() {
		Map<Category, List<CategoryDetail>> map=new TreeMap<>();
		// 先查出所有的一级分类信息
		String sql="select * from s_cate";
		List<Category> list = detailDaoImpl.find(sql, null, Category.class);
		//遍历所有的一级分类信息
		//通过一级分类ID查询出对应的所有的二级分类信息
		for (Category cate : list) {
			String sql2="select * from s_cate_detail where category_id= ?";
			//list2即为当前一级分类对应的所有二级分类
			List<CategoryDetail> list2 = detailDaoImpl.find(sql2,new Object[] {cate.getId()},CategoryDetail.class);
			//将一级分类和对应的二级分类保存到map集合内
			map.put(cate, list2);
		}
		return map;
	}

	@Override
	public List<CategoryDetail> getCategoryDetailsByCategoryId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCategoryDetail(CategoryDetail category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCategoryDetail(Long categoryDetailId) {
		// TODO Auto-generated method stub
		
	}

}
