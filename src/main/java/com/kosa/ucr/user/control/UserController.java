package com.kosa.ucr.user.control;

import com.kosa.ucr.control.Controller;
import com.kosa.ucr.user.service.UserService;

public abstract class UserController implements Controller {
	protected UserService service;
	public UserController() {
		service = UserService.getInstance();
	}
}
