package com.briup.service.impl;

import java.util.List;
import java.util.Set;

import com.briup.bean.CategoryDetail;
import com.briup.bean.Product;
import com.briup.common.exception.ProductException;
import com.briup.dao.impl.ProductDaoImpl;
import com.briup.service.IProductService;

public class ProductServiceImpl implements IProductService{
 private ProductDaoImpl productDao=new ProductDaoImpl();
	@Override
	public List<Product> listAllProduct() {
		// 借助于Dao层
		String sql="select * from product";
		List<Product> list = productDao.find(sql, new Object[] {}, Product.class);
		return list;
	}

	@Override
	public Product selectProductById(long productId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listHostProducet() throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByCategoryId(long id) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByCategoryDetailId(long id) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> listPublish() throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(long id) throws ProductException {
		// TODO Auto-generated method stub
		String sql="select * from product where id= ?";
		List<Product> list = productDao.find(sql, new Object[] {id}, Product.class);
		if(list.size()>0)
		{
			String sql2 = "select s.name from product p,s_cate_detail s where p.id=? and s.id=p.cate_detail_id";
			List<CategoryDetail> list2 = productDao.find(sql2, new Object[] {id}, CategoryDetail.class);
			list.get(0).setCate_detail(list2.get(0));
			return list.get(0);
		}
		return null;

	}

	@Override
	public List<String> getCateInfoByProductId(long id) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductBykeyword(String keyword) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
