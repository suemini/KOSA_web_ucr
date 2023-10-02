package com.kosa.ucr.course.control;

import com.kosa.ucr.control.Controller;
import com.kosa.ucr.course.service.CourseService;

public abstract class CourseController implements Controller {
	protected CourseService service;
	public CourseController() {
		service = CourseService.getInstance();
	} //singleton으로 맞춤
	
}
