package com.kosa.ucr.registration.control;

import com.kosa.ucr.control.Controller;
import com.kosa.ucr.registration.service.RegistrationService;

public abstract class RegistrationController implements Controller {
	protected RegistrationService service;
	public RegistrationController() {
		service = RegistrationService.getInstance();
	} //singleton으로 맞추면서 만든 메서드 가져옴
}
