package com.ssafy.vue.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.AnswerDto;
import com.ssafy.vue.model.service.AnswerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//http://localhost:9999/vue/swagger-ui.html
@RestController
@RequestMapping("/answer")
@Api("질문게시판 답변 컨트롤러  API V1")
public class AnswerController {
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private AnswerService answerService;
	
	@ApiOperation(value = "답변게시판 글작성", notes = "새로운 답변글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody @ApiParam(value = "질문 정보.", required = true) AnswerDto answerDto) throws Exception {
		logger.info("writeArticle - 호출");
		if (answerService.writeArticle(answerDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "질문게시판 답변보기", notes = "글번호에 해당하는 게시글의 답변정보를 반환한다.", response = AnswerDto.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<AnswerDto> getArticle(@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true ) int articleno) throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		return new ResponseEntity<AnswerDto>(answerService.getArticle(articleno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "질문게시판 답변수정", notes = "게시글 답변정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody @ApiParam(value = "수정할 글정보.", required = true) AnswerDto answerDto) throws Exception {
		logger.info("modifyArticle - 호출");
		
		if (answerService.modifyArticle(answerDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "질문게시판 답변삭제", notes = "글번호에 해당하는 게시글의 답변정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") @ApiParam(value = "살제할 글의 글번호.", required = true) int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (answerService.deleteArticle(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
}
