package com.ssafy.vue.model.service;



import com.ssafy.vue.model.AnswerDto;

public interface AnswerService {
	public boolean writeArticle(AnswerDto answerDto) throws Exception;
	public AnswerDto getArticle(int articleno) throws Exception;
	public boolean modifyArticle(AnswerDto answerDto) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
}
