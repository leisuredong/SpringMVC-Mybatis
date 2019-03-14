package com.netease.dao;

import java.util.HashMap;
import java.util.List;

import com.netease.entity.Content;
import com.netease.entity.Item;

public interface ContentDao {

	public boolean insertContent(Content content);

	public List<Object> getContent();
	
	public boolean deleteContent(int id);
	
	public Content getContentById(int id);
	
	public boolean updateContent(Content content);
	
	public boolean insertItem(Item item);
	
	public boolean updateSold(int id);
	
	public List<HashMap<String, String>> getItem();
	
	public int getItemPriceById(int id);
}
