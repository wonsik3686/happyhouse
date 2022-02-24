package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.DealDto;
import com.ssafy.vue.model.mapper.DealMapper;


@Service
public class DealServiceImpl implements DealService {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<DealDto> officeRentList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).officeRentList(deal);
	}
	
	@Override
	public int getTotCntOfficeRent(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntOfficeRent(deal);
	}
	@Override
	public List<DealDto> officeDealList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).officeDealList(deal);
	}
	
	@Override
	public int getTotCntOfficeDeal(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntOfficeDeal(deal);
	}

	@Override
	public List<DealDto> homeRentList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).homeRentList(deal);
	}
	
	@Override
	public int getTotCntHomeRent(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntHomeRent(deal);
	}
	
	@Override
	public List<DealDto> homeDealList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).homeDealList(deal);
	}
	
	@Override
	public int getTotCntHomeDeal(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntHomeDeal(deal);
	}
	
	@Override
	public List<DealDto> aptRentList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).aptRentList(deal);
	}
	
	@Override
	public int getTotCntAptRent(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntAptRent(deal);
	}
	
	@Override
	public List<DealDto> aptDealList(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).aptDealList(deal);
	}
	@Override
	public int getTotCntAptDeal(DealDto deal) throws Exception {
		return sqlSession.getMapper(DealMapper.class).getTotCntAptDeal(deal);
	}
	

}
