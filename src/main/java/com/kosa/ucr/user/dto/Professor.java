package com.kosa.ucr.user.dto;

import com.kosa.ucr.course.dto.Major;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Professor {
	int proId;
	String proPwd;
	String proName;
	String proIdenNum;
	String proEmail;
	String proPhone;
	Major mName;
}
