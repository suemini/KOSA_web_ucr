package com.kosa.ucr.course.dto;

import com.kosa.ucr.user.dto.Professor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Course {
	private String coCode;
	private String coName;
	private int coYear;
	private int coLimit;
	private int coCredit;
	private String classroom;
	private String division;
	private String coDay;
	private String coTime;
	private int regiCnt;
	private Major mName;
	//String mName; 위에 방법으로 has a관계 나타내기
	private Professor proName;
}
