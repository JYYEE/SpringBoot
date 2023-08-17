package com.minjung.silver.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 추가 확장은 본인 선택! (상황과 맥락에 맞추어성)
public class SujinVO {
	private int sujinNum;
	private String sujinName;
	private String sujinContent;
}
