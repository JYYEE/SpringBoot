package com.minjung.silver.service;

import java.util.List;

import com.minjung.silver.vo.SujinVO;

// 기본적인 패턴은 Mapper 인터페이스와 똑같음
// 프로젝트 규모와 성격에 따라 다른 방향으로 진화
// DB에 자주 연결하지 않고 메모리에 데이터 가지고 있다가 주기적으로 요청할 때 service가 DB에 넣어주는 방식 
// interface는 객체화 안됨 -> 어노테이션 xxxxx
public interface SujinService {
	public List<SujinVO> sujinList();
	public SujinVO sujinOne(int sujinNum);
	public int sujinInsert(SujinVO sujinVO);
	public int sujinUpdate(SujinVO sujinVO);
	public int sujinDelete(int sujinNum);
}
