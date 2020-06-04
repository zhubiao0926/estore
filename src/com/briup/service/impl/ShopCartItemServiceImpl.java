package com.briup.service.impl;

import java.util.List;

import com.briup.bean.Report;
import com.briup.bean.ShopCartItem;
import com.briup.dao.impl.ShopCartItemDaoImpl;
import com.briup.service.IShopCartItemService;

import com.briup.web.view.ShopItemInfo;

public class ShopCartItemServiceImpl implements IShopCartItemService{
    ShopCartItemDaoImpl ShopCartItemDaoImpl = new ShopCartItemDaoImpl();
    
		// TODO Auto-generated constructor stub
	@Override
	public void saveShopCartItem(ShopCartItem sc) {
		// TODO Auto-generated method stub
		
		String sql2= "select * from s_shopcart_item where user_id=? and product_id=?";
		List<ShopCartItem> find = ShopCartItemDaoImpl.find(sql2, new Object[] {sc.getUser().getId(),sc.getProduct().getId()}, ShopCartItem.class);
		if(find.size()==0) {
		 String sql = "insert into S_SHOPCART_ITEM VALUES(my_seq.nextval,?,?,?)";
		 ShopCartItemDaoImpl.executeUpdate(sql,new Object[] {sc.getUser().getId(),sc.getProduct().getId(),sc.getNum()});
	    }
		else {
//			String sql = "update s_shopcart_item set num=num+? where user_id=? and product_id=?";
//			 ShopCartItemDaoImpl.executeUpdate(sql,new Object[] {sc.getNum(),sc.getUser().getId(),sc.getProduct().getId()});
			 sc.setNum(sc.getNum()+find.get(0).getNum());
			 sc.setId(find.get(0).getId());
			 updateShopCartItem(sc);
		}
	}
	@Override
	public void deleteShopCartItem(long id) {
		// TODO Auto-generated method stub
		String sql = "delete from s_shopcart_item where id=?";
		ShopCartItemDaoImpl.executeUpdate(sql, new Object[] {id});
	}

	@Override
	public void updateShopCartItem(ShopCartItem sc) {
		// TODO Auto-generated method stub
		String sql = "update s_shopcart_item set num=? where id=?";
		 ShopCartItemDaoImpl.executeUpdate(sql,new Object[] {sc.getNum(),sc.getId()});
	}

	@Override
	public List<ShopItemInfo> listItemByUserId(long uid) {
		String sql = "select * from s_shopcart_item,product where s_shopcart_item.user_id = ? and s_shopcart_item.product_id =product.id ";
		List<ShopItemInfo> ShopItemInfo = ShopCartItemDaoImpl.find(sql, new Object[] {uid}, ShopItemInfo.class);
		return ShopItemInfo;
	}

	@Override
	public List<ShopItemInfo> listItemByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
