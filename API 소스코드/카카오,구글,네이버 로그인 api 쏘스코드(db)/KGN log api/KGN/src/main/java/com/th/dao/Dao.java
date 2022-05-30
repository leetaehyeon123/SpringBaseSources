package com.th.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.th.vo.Vo;

public class Dao {

	private SqlSession sqlSession;
	public Dao(SqlSession sqlSession){this.sqlSession = sqlSession;}
	
	public List<Vo> selectEmail(Vo vo) {
		return sqlSession.selectList("com.th.mappers.testMapper.selectEmail", vo);
	}
	public List<Vo> selectPhoneNum(Vo vo) {
		return sqlSession.selectList("com.th.mappers.testMapper.selectPhoneNum", vo);
	}
	public void insert(Vo vo) {
		sqlSession.insert("com.th.mappers.testMapper.insert",vo);
	}
	public void update(Vo vo) {
		sqlSession.update("com.th.mappers.testMapper.update",vo);
	}
	
	
}
