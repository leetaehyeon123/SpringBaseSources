package com.th.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.th.vo.Vo;

public class Dao {
	@Autowired
	SqlSession sqlSession;
	
	Dao(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	public List<Vo> select(String searchName){
		return sqlSession.selectList("com.th.mappers.testMapper.select",searchName);
	}
	
	public void insert(Vo vo) {
		sqlSession.insert("com.th.mappers.testMapper.insert", vo);
	}
	
	public void update(Vo vo) {
		sqlSession.update("com.th.mappers.testMapper.update",vo);
	}
	
	public void delete(Vo vo) {
		sqlSession.delete("com.th.mappers.testMapper.delete",vo);
	}
	
	
}
