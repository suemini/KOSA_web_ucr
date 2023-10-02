package com.kosa.ucr.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Notice {
	private int noticeNo;
	private String title;
	private String contents;
}
