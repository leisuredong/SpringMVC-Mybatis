package com.netease.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netease.entity.Content;
import com.netease.entity.Item;

public class ContentDaoImpl implements ContentDao {
	private SqlSession session;
	public static ContentDaoImpl contentDaoImpl;

	public static ContentDaoImpl getInstance() {
		if (contentDaoImpl == null)
			return new ContentDaoImpl();
		else
			return contentDaoImpl;
	}

	public ContentDaoImpl() {
		String resource = "com/netease/dao/mybatis.xml";
		InputStream is = ContentDaoImpl.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}

	@Override
	public boolean insertContent(Content content) {
		String statement = "com.netease.dao.mapping.insertContent";
		int num = session.insert(statement, content);
		if (num == 0)
			return false;
		session.commit();
		return true;
	}

	@Override
	public List<Object> getContent() {
		String statement = "com.netease.dao.mapping.getContent";
		List<Object> contents = session.selectList(statement);
		return contents;
	}

	@Override
	public boolean deleteContent(int id) {
		String statement = "com.netease.dao.mapping.deleteContent";
		int num = session.delete(statement, id);
		if (num == 0)
			return false;
		session.commit();
		return true;
	}

	@Override
	public Content getContentById(int id) {
		String statement = "com.netease.dao.mapping.getContentById";
		Content content = session.selectOne(statement, id);
		return content;
	}

	@Override
	public boolean updateContent(Content content) {
		String statement = "com.netease.dao.mapping.updateContent";
		int num = session.update(statement, content);
		if (num == 0)
			return false;
		session.commit();
		return true;
	}

	@Override
	public boolean insertItem(Item item) {
		String statement = "com.netease.dao.mapping.insertItem";
		int num = session.insert(statement, item);
		if (num == 0)
			return false;
		session.commit();
		return true;
	}

	@Override
	public boolean updateSold(int id) {
		String statement = "com.netease.dao.mapping.updateSold";
		int num = session.update(statement, id);
		if (num == 0)
			return false;
		session.commit();
		return true;
	}

	@Override
	public List<HashMap<String, String>> getItem() {
		String statement = "com.netease.dao.mapping.getItem";
		List<HashMap<String, String>> items = session.selectList(statement);
		return items;
	}

	@Override
	public int getItemPriceById(int id) {
		String statement = "com.netease.dao.mapping.getItemPriceById";
		int price = session.selectOne(statement, id);
		return price;
	}
}
