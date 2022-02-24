package com.ssafy.vue.model.service;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.AnswerDto;
import com.ssafy.vue.model.mapper.AnswerMapper;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public boolean writeArticle(AnswerDto answerDto) throws Exception {
		if(answerDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(AnswerMapper.class).writeArticle(answerDto) == 1;
	}

	@Override
	public AnswerDto getArticle(int articleno) throws Exception {
		return sqlSession.getMapper(AnswerMapper.class).getArticle(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(AnswerDto answerDto) throws Exception {
		return sqlSession.getMapper(AnswerMapper.class).modifyArticle(answerDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return sqlSession.getMapper(AnswerMapper.class).deleteArticle(articleno) == 1;
	}



}
