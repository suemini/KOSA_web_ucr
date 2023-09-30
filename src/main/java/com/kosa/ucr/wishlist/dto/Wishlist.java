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
	String coCode; //Course의 coCode로 하면 dao에서 wl.set이 안됨
	int stuId; //(insertWishlit메서드 매개변수와 타입이 안 맞아서)
}
