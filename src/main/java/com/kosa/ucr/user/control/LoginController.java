package com.kosa.ucr.user.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.FindException;


public class LoginController extends UserController{
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//크로스오리진 문제해결 DispatcherServlet으로 이사감
		//응답형식
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		//out.print("로그인성공");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");

		Map<String, Object> map = new HashMap<>();

		HttpSession session = request.getSession();
		session.removeAttribute("loginedId");
		if(idString.length() == 8) {
			try {
				service.loginStudent(id, pwd);
				map.put("status", 2);
				map.put("msg", "학생 로그인 성공");

				session.setAttribute("loginedId", id);
			} catch (FindException e) {
				//					e.printStackTrace();
				map.put("status", 0);
				map.put("msg", "로그인 실패");
			}
		}else if(idString.length() == 6) {
			try {
				service.loginStudent(id, pwd);
				map.put("status", 1);
				map.put("msg", "교수 로그인 성공");

				session.setAttribute("loginedId", id);
			} catch (FindException e) {
				//					e.printStackTrace();
				map.put("status", 0);
				map.put("msg", "로그인 실패");
			}
		}
		
		String jsonStr = mapper.writeValueAsString(map);
		out.print(jsonStr);
		return null;
	}

}
