package com.minjung.silver.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minjung.silver.vo.SujinVO;

@SpringBootTest
public class SujinMapperTest {
	
	@Autowired
	private SujinMapper sujinMapper;
	
	@Test	// 마우스 우클릭 > run as> junit 생김
	@DisplayName("수진맵퍼 테스통")
	public void insertTest() {
//		SujinVO sujinVO = new SujinVO();
//		sujinVO.setSujinName("안수진");
//		sujinVO.setSujinContent("안내용이디용");
		//assertEquals("기대값", "실제값");
		
		// 테스트 뿐만 아니라 더미데이터 넣는 것으로 활용해도 좋음
		SujinVO sujinVO;
		for (int i = 1; i <= 20; i++) {
			sujinVO = new SujinVO();
			sujinVO.setSujinName("안수진 " + i);
			sujinVO.setSujinContent("안내용이디용 " + i);
			assertEquals(1, sujinMapper.sujinInsert(sujinVO));
		}
	}
}
