package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_TestDAO;
import com.human.vo.TestVO;
@Service
public class TestServiceImpl implements IF_TestService{

	@Inject
	private IF_TestDAO tdao;
	
	@Override
	public void test_insert(TestVO tvo) throws Exception {
		tdao.Test_insert(tvo);
		
	}

}
