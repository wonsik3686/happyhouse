package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.InterestLocationDto;

@Mapper
public interface InterestLocationMapper {
	List<InterestLocationDto> getLocationsById(String userid) throws SQLException;
	void setLocation(InterestLocationDto interestLocationDto) throws SQLException;
}
