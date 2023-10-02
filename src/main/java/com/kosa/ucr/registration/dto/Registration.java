package com.kosa.ucr.registration.dto;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.user.dto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Registration {
	private List<Course> courses;
	private Student stuId;
}
