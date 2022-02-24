package com.ssafy.vue.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.AnswerDto;

@Mapper
public interface AnswerMapper {
	public int writeArticle(AnswerDto answerDto) throws SQLException;
	public AnswerDto getArticle(int articleno) throws SQLException;
	public int modifyArticle(AnswerDto answerDto) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
}
