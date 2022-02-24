package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AnswerDto : 답변정보", description = "답변의 상세 정보를 나타낸다.")
public class AnswerDto {
	@ApiModelProperty(value = "답변번호")
	private int answerno;
	@ApiModelProperty(value = "글번호")
	private int articleno;
	@ApiModelProperty(value = "작성자 아이디")
	private String userid;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "작성일")
	private String regtime;
	public int getAnswerno() {
		return answerno;
	}
	public void setAnswerno(int answerno) {
		this.answerno = answerno;
	}
	public int getArticleno() {
		return articleno;
	}
	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
}
