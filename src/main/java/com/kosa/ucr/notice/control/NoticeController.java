package com.kosa.ucr.notice.control;

import com.kosa.ucr.notice.service.NoticeService;
import com.kosa.ucr.control.Controller;



public abstract class NoticeController implements Controller{
	protected NoticeService service;
	public NoticeController() {
		service = NoticeService.getInstance();
	}
}
