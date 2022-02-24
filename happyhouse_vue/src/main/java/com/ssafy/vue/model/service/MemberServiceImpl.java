package com.ssafy.vue.model.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.controller.MemberController;
import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	public static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
	}

	@Override
	public void signUp(MemberDto memberDto) throws SQLException {
		sqlSession.getMapper(MemberMapper.class).signUp(memberDto);		
	}

	@Override
	public int idCheck(String userid) throws SQLException {
		int res = sqlSession.getMapper(MemberMapper.class).idCheck(userid);
		logger.debug("idcheck - count - : {} ", res);
		return res;
	}
	
	@Override
	public void updateMember(MemberDto memberDto) throws SQLException {
		sqlSession.getMapper(MemberMapper.class).updateMember(memberDto);
	}

	@Override
	public void deleteMember(String userid) throws SQLException {
		sqlSession.getMapper(MemberMapper.class).deleteMember(userid);			
	}

}
