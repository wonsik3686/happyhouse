package com.ssafy.vue.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.HouseDealDto;
import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.InterestLocationDto;
import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.service.HouseMapService;
import com.ssafy.vue.model.service.InterestLocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/map")
@Api("Map 컨트롤러  API V1")
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService haHouseMapService;
	
	@Autowired
	private InterestLocationService interestLocationService;
	
	@ApiOperation(value = "관심지역 정보", notes = "유저의 관심지역 정보를 반환한다.", response = List.class)
	@GetMapping("/interest/{userid}")
	public ResponseEntity<List<InterestLocationDto>> getInterest(@PathVariable("userid") @ApiParam(value = "회원의 아이디.", required = true) String userid) throws Exception {
		logger.info("getInterest - 호출");
		return new ResponseEntity<List<InterestLocationDto>>(interestLocationService.getLocationsById(userid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심지역 설정", notes = "유저의 관심지역 정보를 설정한다.", response = List.class)
	@PostMapping("/interest")
	public ResponseEntity<Map<String, Object>> setInterest(@RequestBody @ApiParam(value = "회원정보 수정 시 필요한 회원정보.", required = true) InterestLocationDto interestLocationDto) throws Exception {
		logger.info("setInterest - 호출");
		logger.info("userid - {}", interestLocationDto.getUserid());
		logger.info("getSido - {}", interestLocationDto.getSido());
		logger.info("getGugun - {}", interestLocationDto.getGugun());
		logger.info("getDong - {}", interestLocationDto.getDong());
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			interestLocationService.setLocation(interestLocationDto);
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (SQLException e) {
			resultMap.put("message", "fail");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군 정보", notes = "해당 시도의 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		logger.info("gugun - 호출");
		
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}
	@ApiOperation(value = "동 정보", notes = "해당 구군의 동을 반환한다.", response = List.class)
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		logger.info("dong - 호출");
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
//	
	@ApiOperation(value = "아파트 info 정보", notes = "아파트 info을 반환한다.", response = List.class)
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
		logger.info("houseinfo - 호출");
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
	}
	@ApiOperation(value = "아파트 detail 정보", notes = "아파트 detail을 반환한다.", response = List.class)
	@GetMapping("/deal")
	public ResponseEntity<List<HouseDealDto>> deal(@RequestParam("aptCode") int aptCode) throws Exception{
		logger.info("housedeal - 호출");
		return new ResponseEntity<List<HouseDealDto>>(haHouseMapService.getAptdealInAptCode(aptCode),HttpStatus.OK);
	}
	
}
