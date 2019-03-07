package com.netease.service;

import java.util.ArrayList;

import com.netease.dao.ContentDao;
import com.netease.dao.ContentDaoImpl;
import com.netease.dao.UserDao;
import com.netease.dao.UserDaoImpl;
import com.netease.entity.Content;
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
	public ArrayList<Content> getContent() {
		contentDao = ContentDaoImpl.getInstance();
		return contentDao.getContent();
	}
}
