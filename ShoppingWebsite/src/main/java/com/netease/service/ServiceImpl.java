package com.netease.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.netease.dao.ContentDao;
import com.netease.dao.UserDao;
import com.netease.entity.Content;
import com.netease.entity.Item;
import com.netease.entity.User;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Autowired
	private ContentDao contentDao;

	@Override
	public boolean insertContent(Content content) {
		return contentDao.insertContent(content);
	}

	@Override
	public List<Object> getContent() {
		return contentDao.getContent();
	}

	@Override
	public boolean deleteContent(int id) {
		return contentDao.deleteContent(id);
	}

	@Override
	public Content getContentById(int id) {
		return contentDao.getContentById(id);
	}

	@Override
	public boolean updateContent(Content content) {
		return contentDao.updateContent(content);
	}

	@Override
	public boolean insertItem(Item item) {
		return contentDao.insertItem(item);
	}

	@Override
	public boolean updateSold(int id) {
		return contentDao.updateSold(id);
	}

	@Override
	public List<HashMap<String, String>> getItem() {
		return contentDao.getItem();
	}

	@Override
	public int getItemPriceById(int id) {
		return contentDao.getItemPriceById(id);
	}
}
