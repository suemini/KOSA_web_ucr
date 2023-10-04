package com.kosa.ucr.user.service;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dao.ProfessorOracleMybatisRepository;
import com.kosa.ucr.user.dao.StudentOracleMybatisRepository;
import com.kosa.ucr.user.dto.Professor;
import com.kosa.ucr.user.dto.Student;

public class UserService {
	private ProfessorOracleMybatisRepository repositoryP;
	private StudentOracleMybatisRepository repositoryS;
	private static UserService service = new UserService();
	private UserService() {
		repositoryP = new ProfessorOracleMybatisRepository();
		repositoryS = new StudentOracleMybatisRepository();
	}
	
	public static UserService getInstance() {
		return service;
	}

	public void loginProfessor(int id, String pwd) throws FindException{
		Professor p = repositoryP.selectProfessorById(id);	
		if(!p.getProPwd().equals(pwd)) {
			throw new FindException();
		}
	}
	
	public void loginStudent(int id, String pwd) throws FindException{
		Student s = repositoryS.selectStudentById(id);	
		if(!s.getStuPwd().equals(pwd)) {
			throw new FindException();
		}
	}

}