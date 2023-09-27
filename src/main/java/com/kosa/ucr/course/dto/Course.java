package com.kosa.ucr.course.dto;

import com.kosa.ucr.user.dto.Professor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Course {
	String coCode;
	String coName;
	int coYear;
	int coLimit;
	int coCredit;
	String classroom;
	String division;
	String coDay;
	String coTime;
	int regiCnt;
	Major mName;
	//String mName; 위에 방법으로 has a관계 나타내기
	Professor proName;
}
