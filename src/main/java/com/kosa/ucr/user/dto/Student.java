package com.kosa.ucr.user.dto;

import com.kosa.ucr.course.dto.Major;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Student {
	private int stuId;
	private String stuPwd;
	private String stuName;
	private String stuIdenNum;
	private String stuEmail;
	private String stuPhone;
	private int stuCredits;
	private int stuGrades;
	private Major coMajorName;
}
