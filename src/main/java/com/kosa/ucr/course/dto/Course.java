package com.kosa.ucr.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Course {
	int coCode;
	String coName;
	int coYear;
	int coLimit;
	int coCredit;
	String classroom;
	String division;
	String coDay;
	String coTime;
}
