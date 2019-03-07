package com.netease.dao;

import java.util.ArrayList;

import com.netease.entity.Content;

public interface ContentDao {

	public boolean insertContent(Content content);

	public ArrayList<Content> getContent();
}
