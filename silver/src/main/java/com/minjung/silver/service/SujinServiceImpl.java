package com.minjung.silver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minjung.silver.mapper.SujinMapper;
import com.minjung.silver.vo.SujinVO;

@Service
public class SujinServiceImpl implements SujinService {
	
	// 서비스는 맵퍼(DAO)를 부름
	@Autowired
	private SujinMapper sujinMapper;
	@Override
	public List<SujinVO> sujinList() {
		return sujinMapper.sujinList();
	}

	@Override
	public SujinVO sujinOne(int sujinNum) {
		return sujinMapper.sujinOne(sujinNum);
	}

	@Override
	public int sujinInsert(SujinVO sujinVO) {
		return sujinMapper.sujinInsert(sujinVO);
	}

	@Override
	public int sujinUpdate(SujinVO sujinVO) {
		return sujinMapper.sujinUpdate(sujinVO);
	}

	@Override
	public int sujinDelete(int sujinNum) {
		return sujinMapper.sujinDelete(sujinNum);
	}

}
