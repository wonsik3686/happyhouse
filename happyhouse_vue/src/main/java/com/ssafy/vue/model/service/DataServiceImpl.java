package com.ssafy.vue.model.service;

import com.ssafy.vue.model.DealDto;
import com.ssafy.vue.model.mapper.DataMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addOfficeRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addOfficeRentData(deal);
	}
	@Override
	public int addOfficeDealData(DealDto deal) throws Exception{
		return sqlSession.getMapper(DataMapper.class).addOfficeDealData(deal);
	}
	@Override
	public int addHomeRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addHomeRentData(deal);
	}
	
	@Override
	public int addHomeDealData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addHomeDealData(deal);
	}
	
	@Override
	public int addAptRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addAptRentData(deal);
	}
	
	@Override
	public int addAptDealData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addAptDealData(deal);
	}

}