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

	public void loginProfessor(String id, String pwd) throws FindException{
		Professor p = repositoryP.selectProfessorById(id);	
		if(!p.getProPwd().equals(pwd)) {
			throw new FindException();
		}
	}
	
	public void loginStudent(String id, String pwd) throws FindException{
		Student s = repositoryS.selectStudentById(id);	
		if(!s.getStuPwd().equals(pwd)) {
			throw new FindException();
		}
	}
	
	public String findProfessorId(String name, String idenNum, String phone) throws FindException{
		return repositoryP.selectProfessorByUserInfo(name, idenNum, phone);
	}
	
	public String findStudentId(String name, String idenNum, String phone) throws FindException{
		return repositoryS.selectStudentByUserInfo(name, idenNum, phone);
	}
	
	public String findProfessorPwd(String id, String name, String idenNum, String phone) throws FindException{
		return repositoryP.selectProfessorByIdInfo(id, name, idenNum, phone);
	}
	
	public String findStudentPwd(String id, String name, String idenNum, String phone) throws FindException{
		return repositoryS.selectStudentByIdInfo(id, name, idenNum, phone);
	}
	
	

}