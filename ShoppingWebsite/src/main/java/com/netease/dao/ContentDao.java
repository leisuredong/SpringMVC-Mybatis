package com.netease.dao;

import java.util.List;

import com.netease.entity.Content;

public interface ContentDao {

	public boolean insertContent(Content content);

	public List<Object> getContent();
	
	public boolean uploadPic(String path);
}
