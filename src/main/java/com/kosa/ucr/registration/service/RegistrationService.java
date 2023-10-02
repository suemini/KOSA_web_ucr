package com.kosa.ucr.registration.service;

import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.RemoveException;
import com.kosa.ucr.registration.dao.RegistrationOracleMybatisRepository;
import com.kosa.ucr.registration.dao.RegistrationRepository;


public class RegistrationService {
	private RegistrationRepository repository;
	//wishlistService singleton으로 맞춰줌
	private static RegistrationService service = new RegistrationService();
	private RegistrationService() {
		repository = new RegistrationOracleMybatisRepository();
	}
	public static RegistrationService getInstance() {
		return service;
	}
	
	//addWishlist
	public void addRegistration(String coCode, int stuId) throws AddException {
		repository.insertRegistration(coCode, stuId);
	}
	
	//removeWishlist
	public void removeRegistration(String coCode, int stuId) throws RemoveException{
		repository.deleteRegistration(coCode, stuId);
	}
}
