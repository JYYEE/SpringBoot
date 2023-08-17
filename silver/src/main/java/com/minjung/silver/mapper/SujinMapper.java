package com.minjung.silver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.minjung.silver.vo.SujinVO;

@Mapper	// default로 찾아오지만 명시적으로 언급해주기위해서 붙이는 걸 추천
public interface SujinMapper {
	/* 
	 * 기본적으로 5개 *, list, one, insert, update, delete 만들어주기
	 * 당연히 필요한 것 만들고 시작하는게 좋음 
	 */
	// 읽기
	// list
	public List<SujinVO> sujinList();
	// one
	public SujinVO sujinOne(int sujinNum);
	
	// 쓰기
	// insert, update, delete 를 mutation 메소드라 부름
	public int sujinInsert(SujinVO sujinVO);
	public int sujinUpdate(SujinVO sujinVO);
	public int sujinDelete(int sujinNum);
}
