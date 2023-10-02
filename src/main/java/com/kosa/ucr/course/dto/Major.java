package com.kosa.ucr.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Major {
	private int mNo; // 과 번호
	private String mUni; // 단과대
	private String mName; // 과 이름
}
