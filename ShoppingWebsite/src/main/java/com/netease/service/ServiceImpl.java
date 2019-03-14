package com.netease.service;

import java.util.HashMap;
import java.util.List;

import com.netease.dao.ContentDao;
import com.netease.dao.ContentDaoImpl;
import com.netease.dao.UserDao;
import com.netease.dao.UserDaoImpl;
import com.netease.entity.Content;
import com.netease.entity.Item;
import com.netease.entity.User;

public class ServiceImpl implements Service {

	public static ServiceImpl ServiceImpl;

	public static ServiceImpl getInstance() {
		if (ServiceImpl == null)
			return new ServiceImpl();
		else
			return ServiceImpl;
	}

	private UserDao userDao;

	@Override
	public User getUser(int id) {
		userDao = UserDaoImpl.getInstance();
		return userDao.getUser(id);
	}

	private ContentDao contentDao;

	@Override
	public boolean insertContent(Content content) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.insertContent(content);
	}

	@Override
	public List<Object> getContent() {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.getContent();
	}

	@Override
	public boolean deleteContent(int id) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.deleteContent(id);
	}

	@Override
	public Content getContentById(int id) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.getContentById(id);
	}

	@Override
	public boolean updateContent(Content content) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.updateContent(content);
	}

	@Override
	public boolean insertItem(Item item) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.insertItem(item);
	}

	@Override
	public boolean updateSold(int id) {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.updateSold(id);
	}

	@Override
	public List<HashMap<String, String>> getItem() {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.getItem();
	}

	@Override
	public int getItemPriceById(int id) {
		contentDao=ContentDaoImpl.getInstance();
		return contentDao.getItemPriceById(id);
	}
}
