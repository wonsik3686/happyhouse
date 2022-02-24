package com.ssafy.vue.model.service;

import java.sql.SQLException;

import com.ssafy.vue.model.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	public void signUp(MemberDto memberDto) throws SQLException;
	public int idCheck(String userid) throws SQLException;
	public void updateMember(MemberDto memberDto) throws SQLException;
	public void deleteMember(String userid) throws SQLException;
	
}
