package com.kosa.ucr.user.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.FindException;

public class FindPwdController extends UserController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//응답형식
		response.setContentType("application/json;charset=utf-8");
		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
			
		Map<String, Object> map = new HashMap<>();
		
		String id = request.getParameter("id");
		try {
			int idNum = Integer.parseInt(id);
		}catch(NumberFormatException e) {
			map.put("status", 0);
			map.put("msg", "아이디를 정확히 입력하세요");
			out.print(mapper.writeValueAsString(map));
			return null;
		}
		String name = request.getParameter("name");
		String idenNum = request.getParameter("idenNum");
		String phone = request.getParameter("phone");		
				
		try {
			String stuPwd = service.findStudentPwd(id, name, idenNum, phone);
			String proPwd = service.findProfessorPwd(id, name, idenNum, phone);
			
			if(proPwd != "fail") {
				map.put("status", 1);
				map.put("pwd", proPwd);
				map.put("msg", "정보와 일치하는 비밀번호");					
			}else if (stuPwd != "fail") {
				map.put("status", 2);
				map.put("pwd", stuPwd);
				map.put("msg", "정보와 일치하는 비밀번호");		
			}else {
				map.put("status", 0);
				map.put("msg", "정보와 일치하는 비밀번호가 존재하지 않습니다");
			}
		} catch (FindException e) {
			map.put("msg", "비밀번호찾기 실패");
		}
		
		String jsonStr = mapper.writeValueAsString(map);
		out.print(jsonStr);
		return null;
	}

}
