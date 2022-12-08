package com.human.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.TestVO;
@Repository
public class TestDAOImpl implements IF_TestDAO{

	@Inject
	private SqlSession sqlsession;
	
	@Override
	public void Test_insert(TestVO tvo) throws Exception {
		sqlsession.insert("com.human.dao.IF_TestDAO.test_insert",tvo);
		
	}

}
