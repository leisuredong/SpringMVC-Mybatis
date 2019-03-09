package com.netease.service;

import java.util.List;

import com.netease.entity.Content;
import com.netease.entity.User;

public interface Service {

	public User getUser(int id);

	public boolean insertContent(Content content);

	public List<Object> getContent();

	public boolean uploadPic(String path);
}
