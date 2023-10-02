package com.kosa.ucr.course.dto;

import com.kosa.ucr.user.dto.Professor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Major {
	int mNo; // 과 번호
	String mUni; // 단과대
	String mName; // 과 이름
}
