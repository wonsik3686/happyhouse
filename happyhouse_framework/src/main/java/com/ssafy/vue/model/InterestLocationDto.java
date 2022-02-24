package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InterestLocationDto : 관심지역 정보", description = "관심지역 정보를 나타낸다.")
public class InterestLocationDto {
	
	@ApiModelProperty(value = "회원 아이디")
	private String userid;
	@ApiModelProperty(value = "관심 지역 시도")
	private String sido;
	@ApiModelProperty(value = "관심 지역 구군")
	private String gugun;
	@ApiModelProperty(value = "관심 지역 동")
	private String dong;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	
}
