package com.kosa.ucr.registration.dto;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.user.dto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class PastCredits {
	private Student pcStuId;
	private String division;
	private int credit;
}
