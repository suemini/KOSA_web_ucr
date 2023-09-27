package com.kosa.ucr.user.dto;

import com.kosa.ucr.course.dto.Major;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Student {
	int stuId;
	String stuPwd;
	String stuName;
	String stuIdenNum;
	String stuEmail;
	String stuPhone;
	int stuCredits;
	int stuGrades;
	Major mName;
}
