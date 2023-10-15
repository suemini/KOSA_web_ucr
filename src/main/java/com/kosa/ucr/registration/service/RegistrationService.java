package com.kosa.ucr.registration.service;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.exception.RemoveException;
import com.kosa.ucr.registration.dao.RegistrationOracleMybatisRepository;
import com.kosa.ucr.registration.dao.RegistrationRepository;
import com.kosa.ucr.registration.dto.PastCredits;


public class RegistrationService {
	private RegistrationRepository repository;
	//RegistrationService singleton으로 맞춰줌
	private static RegistrationService service = new RegistrationService();
	private RegistrationService() {
		repository = new RegistrationOracleMybatisRepository();
	}
	public static RegistrationService getInstance() {
		return service;
	}
	
	//addRegistration
	public void addRegistration(String coCode,String coDay, String coTime, int stuId) throws AddException {
		try {
			findRegiDupChk(coCode, coDay, coTime, stuId);
			findByRegiCnt(coCode);
			repository.insertRegistration(coCode, stuId);
			upRegiCnt(coCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
	}
	
	public Course findByRegiCnt(String coCode) throws FindException{
		return repository.selectByRegiCnt(coCode);
	}
	
	//findRegiByCoCode
	public void findRegiDupChk(String coCode, String coDay, String coTime, int stuId) throws FindException{
		repository.selectRegiDupChk(coCode, coDay, coTime, stuId);
	}
	
	
	//removeRegistration
	public void removeRegistration(String coCode, int stuId) throws RemoveException{
		try {
			repository.deleteRegistration(coCode, stuId);
			downRegiCnt(coCode);
		} catch (RemoveException e) {
			e.printStackTrace();
			throw new RemoveException(e.getMessage());
		}
	}
	
	//findByRegistraion
	public List<Course> findByRegistration(int stuId) throws FindException{
		return repository.selectByRegistration(stuId);
	}
	
	
	//findForNowCredit
	public List<PastCredits> findForPastCredit(int stuId) throws FindException{
		return repository.selectForPastCredit(stuId);
	}
	
	//regiCnt 증가/감소
	public void upRegiCnt(String coCode) throws AddException{
		repository.increaseRegiCnt(coCode);
	}
	public void downRegiCnt(String coCode) throws RemoveException {
	      repository.decreaseRegiCnt(coCode);
	   }
}
