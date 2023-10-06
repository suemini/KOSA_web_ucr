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

public class FindIdController extends UserController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//응답형식
		response.setContentType("application/json;charset=utf-8");
		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		String name = request.getParameter("name");
		String idenNum = request.getParameter("idenNum");
		String phone = request.getParameter("phone");

		Map<String, Object> map = new HashMap<>();

		
		try {
			String stuId = service.findStudentId(name, idenNum, phone);
			String proId = service.findProfessorId(name, idenNum, phone);
			
			if(proId != "fail") {
				map.put("id", proId);
				map.put("msg", "정보와 일치하는 직번");					
			}else if (stuId != "fail") {
				map.put("id", stuId);
				map.put("msg", "정보와 일치하는 학번");		
			}else {
				map.put("msg", "정보와 일치하는 학번 또는 직번이 존재하지 않습니다");
			}
		} catch (FindException e) {
			map.put("msg", "학번,직번찾기 실패");
		}		
		
		String jsonStr = mapper.writeValueAsString(map);
		out.print(jsonStr);
		return null;
		
	}

}
