package com.briup.service;

import java.util.List;

import com.briup.bean.ShopCartItem;
import com.briup.web.view.ShopItemInfo;

public interface IShopCartItemService {
	
	public void saveShopCartItem(ShopCartItem sc);
	
	public void deleteShopCartItem(long id);
	
	public void updateShopCartItem(ShopCartItem sc);
	
	public List<ShopItemInfo> listItemByUserId(long uid);
	
	public List<ShopItemInfo> listItemByIds(String ids);
	
	
}
