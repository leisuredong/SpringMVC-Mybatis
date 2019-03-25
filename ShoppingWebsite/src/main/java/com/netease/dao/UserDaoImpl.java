package com.netease.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.netease.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SqlSession session;

	public UserDaoImpl() {
		String resource = "com/netease/dao/mybatis.xml";
		InputStream is = UserDaoImpl.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}

	@Override
	public User getUser(int id) {
		String statement = "com.netease.dao.mapping.getUser";
		User user = session.selectOne(statement, id);
		return user;
	}

}
