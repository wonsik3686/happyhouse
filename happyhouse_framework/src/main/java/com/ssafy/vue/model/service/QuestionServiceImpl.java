package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.QuestionDto;
import com.ssafy.vue.model.QuestionParameterDto;
import com.ssafy.vue.model.mapper.QuestionMapper;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writeArticle(QuestionDto questionDto) throws Exception {
		if(questionDto.getSubject() == null || questionDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QuestionMapper.class).writeArticle(questionDto) == 1;
	}

	@Override
	public List<QuestionDto> listArticle(QuestionParameterDto questionParameterDto) throws Exception {
		int start = questionParameterDto.getPg() == 0 ? 0 : (questionParameterDto.getPg() - 1) * questionParameterDto.getSpp();
		questionParameterDto.setStart(start);
		return sqlSession.getMapper(QuestionMapper.class).listArticle(questionParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(QuestionParameterDto questionParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(questionParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(QuestionMapper.class).getTotalCount(questionParameterDto);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / questionParameterDto.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = questionParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < questionParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public QuestionDto getArticle(int articleno) throws Exception {
		return sqlSession.getMapper(QuestionMapper.class).getArticle(articleno);
	}

	@Override
	public void updateHit(int articleno) throws Exception {
		sqlSession.getMapper(QuestionMapper.class).updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(QuestionDto questionDto) throws Exception {
		return sqlSession.getMapper(QuestionMapper.class).modifyArticle(questionDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return sqlSession.getMapper(QuestionMapper.class).deleteArticle(articleno) == 1;
	}

}
