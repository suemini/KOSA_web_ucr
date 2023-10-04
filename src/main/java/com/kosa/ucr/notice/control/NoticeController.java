package com.kosa.ucr.notice.control;

import com.kosa.ucr.notice.service.NoticeService;

public class NoticeController {
	protected NoticeService service;
	public NoticeController() {
		service = NoticeService.getInstance();
	}
}
