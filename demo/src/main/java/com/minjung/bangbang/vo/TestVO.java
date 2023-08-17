package com.minjung.bangbang.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 기본 세팅 3가지
@Getter
@Setter
@ToString	// 디버깅용으로 아주 유용, 빼먹지 말고 사용!
// @Data는 지양. 에러 생기면 찾기 어려움
// @Data는 생성자, hashcode 다 생성함.
public class TestVO {
	private String name;
	private List<String> age;
}
