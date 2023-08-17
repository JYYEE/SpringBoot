package com.minjung.silver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minjung.silver.service.SujinService;
import com.minjung.silver.vo.SujinVO;

// Restful api 구현
@RestController
@RequestMapping("/api")
public class SujinController {
	
	// 컨트롤러는 서비스를 부름
	@Autowired
	private SujinService sujinService;	// interface를 받음
	
	// 리스트 조회 OK!
	@GetMapping(value = "/sujins", produces = "application/json;charset=utf-8")
	public List<SujinVO> sujinList(){
		return sujinService.sujinList();
	}
	
	// 1개 조회 OK!
	@GetMapping(value = "/sujin/{num}", produces = "application/json;charset=utf-8")
	public SujinVO sujinOne(@PathVariable("num") int sujinNum){
		return sujinService.sujinOne(sujinNum);
	}
	// 생성(insert) OK!
	// @ResponseBody 가 생략 된 것(RestController의 역할)
	@PostMapping(value = "/sujin", produces = "application/json;charset=utf-8")
	public int sujinInsert(@RequestBody SujinVO sujinVO) {
		return sujinService.sujinInsert(sujinVO);
	}
	
	// 수정 OK!
	@PutMapping(value = "/sujin", produces = "application/json;charset=utf-8")
	public int sujinUpdate(@RequestBody SujinVO sujinVO) {
		return sujinService.sujinUpdate(sujinVO);
	}
	
	// 삭제 OK!
	@DeleteMapping(value = "/sujin/{num}", produces = "application/json;charset=utf-8")
	public int sujinDelete(@PathVariable("num") int sujinNum) {
		return sujinService.sujinDelete(sujinNum);
	}
	
	// test -> Boomerang이용
}
