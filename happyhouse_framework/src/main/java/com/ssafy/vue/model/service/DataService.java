package com.ssafy.vue.model.service;

import java.sql.SQLException;

import com.ssafy.vue.model.DealDto;

public interface DataService {
	public int addOfficeRentData(DealDto deal) throws Exception;

	public int addOfficeDealData(DealDto deal) throws Exception;

	public int addHomeRentData(DealDto deal) throws Exception;
	
	public int addHomeDealData(DealDto deal) throws Exception;
	
	public int addAptRentData(DealDto deal) throws Exception;
	
	public int addAptDealData(DealDto deal) throws Exception;
	
}
