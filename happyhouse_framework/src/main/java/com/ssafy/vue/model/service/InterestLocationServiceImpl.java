package com.ssafy.vue.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.InterestLocationDto;
import com.ssafy.vue.model.mapper.InterestLocationMapper;

@Service
public class InterestLocationServiceImpl implements InterestLocationService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<InterestLocationDto> getLocationsById(String userid) throws SQLException {
		return sqlSession.getMapper(InterestLocationMapper.class).getLocationsById(userid);
	}

	@Override
	public void setLocation(InterestLocationDto interestLocationDto) throws SQLException {
		sqlSession.getMapper(InterestLocationMapper.class).setLocation(interestLocationDto);
	}

}
