package com.netease.dao;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netease.entity.Content;

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
	public ArrayList<Content> getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
