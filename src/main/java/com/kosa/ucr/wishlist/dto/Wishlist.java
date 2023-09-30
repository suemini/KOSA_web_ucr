package com.kosa.ucr.wishlist.dto;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.course.dto.Major;
import com.kosa.ucr.user.dto.Professor;
import com.kosa.ucr.user.dto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Wishlist {
	List<Course> courses; 
	Student stuId; 
}
