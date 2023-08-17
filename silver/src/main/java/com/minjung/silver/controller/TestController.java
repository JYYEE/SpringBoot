package com.minjung.silver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	// 요걸 많이 씀, Controller + ResponseBody
public class TestController {
	
	// @ResponseBody 이걸 붙이지 않아도 됨!
	@GetMapping("/test")
	public String getTest() {
		log.info("메롱");
		return "테스통!";
	}
	
}
