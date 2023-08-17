package com.minjung.bangbang.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.minjung.bangbang.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class SujinController {
	
	@GetMapping("/")	// 여기에 @RequestMapping 쓰지 않아용!
	public String home() {
		return "home";
	}
	
	// 방법1 - 스프링이 원하는 방향. 개발자가 비즈니스 로직에만 집중.
	// 스프링은 request, response는 안쓰는 방향 추구
	@GetMapping("/sujin")
	@ResponseBody	// 요거이 붙으면 바로 직접 답변!
	public String restGet() {
		return "이수진";
	}
	
	// 방법2 
//	@GetMapping("/sujin")
//	public void restGet(HttpServletResponse res) throws Exception {
//		res.getWriter().write("sujin manse");
//	}
	
	@GetMapping("/sujin/{num}")
	@ResponseBody	
	public String restGet(@PathVariable int num) {
		// pathvariable을 get방식에서 자주 씀!!
		if(num == 1) {
			return "김지완";
		}
		return "변정민";
	}
	// 배열로 보낼 때 => list로 받아야함.
//	@PostMapping(value="/sujin", produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public List<String> restPost(@RequestBody List<String> names) {
//		for (String name : names) {
//			System.out.println(name);
//		}
//		return names;
//	}
	
	// json으로 보낼 때 => map으로 받아야함.
//	@PostMapping(value="/sujin", produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public Map<String, String> restPost(@RequestBody Map<String, String> myMap) {
//		System.out.println(myMap.get("name"));
//		System.out.println(myMap.get("age"));
//		return myMap;
//	}
	/*
	 * 대부분 클라이언트 <-> 값 주고 받기만 잘해도 자신감이 뿡뿡!
	 * [json]으로 보낼 때
	 */
//	@PostMapping(value="/sujin", produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public List<Map<String, String>> restPost(@RequestBody List<Map<String, String>> myListMap) {
//		for (Map<String, String> map : myListMap) {
//			System.out.println(map.get("name"));
//			System.out.println(map.get("age"));
//			System.out.println("==================");
//		}
//		return myListMap;
//	}
	/*
	 * [json에 value값으로 배열]보낼 때
	 * 데이터 타입이 이것저것 섞이면 어쩔 수 없이 모든걸 받을 수 있는 최상위 Object가 와야함.
	 * 필요하다면 꺼낼 때 형(데이터 타입)변환이 필요할 때도 있음
	 */
	// vo 생성 전
//	@PostMapping(value="/sujin", produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public List<Map<String, Object>> restPost(@RequestBody List<Map<String, Object>> myListMap) {
//		for (Map<String, Object> map : myListMap) {
//			System.out.println(map.get("name"));
//			System.out.println(map.get("age"));
//			System.out.println("==================");
//		}
//		return myListMap;
//	}
	// vo 생성 후
	// Map으로 자주 받게 되는 데이터가 있다면, 아예 별도 VO 형태로 맹금!
	@PostMapping(value="/sujin", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<TestVO> restPost(@RequestBody List<TestVO> myListMap) {
		for (TestVO testVO : myListMap) {
			System.out.println(testVO.getName());
			System.out.println(testVO.getAge());
			System.out.println("==================");
		}
		return myListMap;
	}
	
	@PutMapping(value="/sujin", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<TestVO> restPut(@RequestBody List<TestVO> myListMap) {
		for (TestVO testVO : myListMap) {
			System.out.println(testVO.getName());
			System.out.println(testVO.getAge());
			System.out.println("==================");
		}
		return myListMap;
	}
	@DeleteMapping(value="/sujin", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<TestVO> restDel(@RequestBody List<TestVO> myListMap) {
		for (TestVO testVO : myListMap) {
			System.out.println(testVO.getName());
			System.out.println(testVO.getAge());
			System.out.println("==================");
		}
		return myListMap;
	}
	
	// 파일 업로드
	@PostMapping(value="/mfile", produces = "application/json;charset=utf-8")
	@ResponseBody
	// formData 받을 때는 @RequestBody를 사용하지 않음
	public String restFile(MultipartFile myFile) throws Exception, IOException {
		log.info(myFile.getOriginalFilename());
		log.info(""+myFile.getSize());
		
		String destPath = "d:/upload/" + myFile.getOriginalFilename();
		
		myFile.transferTo(new File(destPath));
		return "/upload/"+myFile.getOriginalFilename();
	}
}
