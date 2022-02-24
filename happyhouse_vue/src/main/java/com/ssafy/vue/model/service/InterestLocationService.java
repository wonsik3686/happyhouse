package com.ssafy.vue.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.vue.model.InterestLocationDto;

public interface InterestLocationService {
	List<InterestLocationDto> getLocationsById(String userid) throws SQLException;
	void setLocation(InterestLocationDto interestLocationDto) throws SQLException;
}
