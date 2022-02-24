package com.ssafy.vue.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.DealDto;
import com.ssafy.vue.model.service.DealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/house")
@Api(value="house", description="Happy house")
public class DealController {
	
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private DealService dealService;
	
	/* 오피스텔 전/월세 정보 */
	@ApiOperation(value = "오피스텔 전/월세 정보 조회 (페이지당 10개) type: 1 = 월세, 2 = 전세", response = List.class)
	@RequestMapping(value = {"/officeRentList/{type}/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> officeRentList(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------officeRentList--------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,currentPage,10);
		List<DealDto> deals = dealService.officeRentList(deal);
		
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
	/* 오피스텔 전/월세 정보 전체 수 */
	@ApiOperation(value = "오피스텔 전/월세 정보 전체 수 type: 1 = 월세, 2 = 전세", response = List.class)
	@RequestMapping(value = {"/getTotCntOfficeRent/{type}/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntOfficeRent(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntOfficeRent-----------------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntOfficeRent(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
	
	/* 오피스텔 매매 정보 */
	@ApiOperation(value = "오피스텔 매매 정보 조회 (페이지당 10개)", response = List.class)
	@RequestMapping(value = {"/officeDealList/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> officeDealList(@PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------officeDealList--------------------"+new Date());
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,currentPage,10);
		List<DealDto> deals = dealService.officeDealList(deal);
		
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
	
	/* 오피스텔 매매 정보 전체 수 */
	@ApiOperation(value = "오피스텔 매매 정보 전체 수", response = List.class)
	@RequestMapping(value = {"/getTotCntOfficeDeal/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntOfficeDeal(@PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntOfficeDeal-----------------------------"+new Date());
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntOfficeDeal(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
	
	/* 연립 다세대 전/월세 정보 */
	@ApiOperation(value = "연립 다세대 전/월세 정보 조회 (페이지당 10개) type: 1 = 월세, 2 = 전세 ", response = List.class)
	@RequestMapping(value = {"/homeRentList/{type}/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> homeRentList(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------homeRentList--------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,currentPage,10);
		List<DealDto> deals = dealService.homeRentList(deal);
		
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
	
	/* 연립 다세대 전/월세 정보 전체 수 */
	@ApiOperation(value = "연립 다세대 전/월세 정보 전체 수 type: 1 = 월세, 2 = 전세", response = List.class)
	@RequestMapping(value = {"/getTotCntHomeRent/{type}/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntHomeRent(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntHomeRent-----------------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntHomeRent(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
	
	/* 연립 다세대 매매 정보 */
	@ApiOperation(value = "연립 다세대 매매 정보 조회 (페이지당 10개)", response = List.class)
	@RequestMapping(value = {"/homeDealList/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> homeDealList(@PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------homeDealList--------------------"+new Date());
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,currentPage,10);
		List<DealDto> deals = dealService.homeDealList(deal);
		
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
	
	/* 연립 다세대 매매 정보 전체 수 */
	@ApiOperation(value = "연립 다세대 매매 정보 전체 수", response = List.class)
	@RequestMapping(value = {"/getTotCntHomeDeal/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntHomeDeal(@PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntHomeDeal-----------------------------"+new Date());
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntHomeDeal(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
		
	/* 아파트 전/월세 정보 */
	@ApiOperation(value = "아파트 전/월세 정보 조회 (페이지당 10개)", response = List.class)
	@RequestMapping(value = {"/aptRentList/{type}/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> aptRentList(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------aptRentList--------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,currentPage,10);
		List<DealDto> deals = dealService.aptRentList(deal);
		
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
		
	/* 아파트 전/월세 정보 전체 수 */
	@ApiOperation(value = "아파트 전/월세 정보 전체 수", response = List.class)
	@RequestMapping(value = {"/getTotCntAptRent/{type}/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntAptRent(@PathVariable int type, @PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntAptRent-----------------------------"+new Date());
		DealDto deal = new DealDto(type,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntAptRent(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
	
	/* 아파트 매매 정보 */
	@ApiOperation(value = "아파트 매매 정보 조회 (페이지당 10개)", response = List.class)
	@RequestMapping(value = {"/aptDealList/{gugunCode}/{dong}/{currentPage}"},method=RequestMethod.GET)
	public ResponseEntity<List<DealDto>> aptDealList(@PathVariable String gugunCode, @PathVariable String dong, @PathVariable int currentPage) throws Exception {
		logger.info("-------------------aptDealList--------------------"+new Date());
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,currentPage,10);
		logger.info(gugunCode);
		logger.info(" " + currentPage);
		logger.info(dong);
		List<DealDto> deals = dealService.aptDealList(deal);
		logger.info("deal  = " + deal);
		if (deals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DealDto>>(deals, HttpStatus.OK);
	}
	
	/* 아파트 매매 정보 전체 수 */
	@ApiOperation(value = "아파트 매매 정보 전체 수", response = List.class)
	@RequestMapping(value = {"/getTotCntAptDeal/{gugunCode}/{dong}"},method=RequestMethod.GET)
	public ResponseEntity<Integer> getTotCntAptDeal(@PathVariable String gugunCode, @PathVariable String dong) throws Exception {
		logger.info("1-------------getTotCntAptDeal-----------------------------"+new Date());
		
		DealDto deal = new DealDto(0,gugunCode.substring(0, 5),dong,0,10);
		int tot = dealService.getTotCntAptDeal(deal);
		
		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
	}
	

}
