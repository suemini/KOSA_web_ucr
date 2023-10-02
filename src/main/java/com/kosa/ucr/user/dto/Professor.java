package com.kosa.ucr.user.dto;

import com.kosa.ucr.course.dto.Major;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Professor {
	private int proId;
	private String proPwd;
	private String proName;
	private String proIdenNum;
	private String proEmail;
	private String proPhone;
	private Major mName;
}
