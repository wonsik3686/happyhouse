package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.QuestionDto;
import com.ssafy.vue.model.QuestionParameterDto;

@Mapper
public interface QuestionMapper {
	public int writeArticle(QuestionDto questionDto) throws SQLException;
	public List<QuestionDto> listArticle(QuestionParameterDto questionParameterDto) throws SQLException;
	public int getTotalCount(QuestionParameterDto questionParameterDto) throws SQLException;
	public QuestionDto getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(QuestionDto questionDto) throws SQLException;
	public void deleteMemo(int articleno) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	
}
