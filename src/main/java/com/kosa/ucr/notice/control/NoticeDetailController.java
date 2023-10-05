package com.kosa.ucr.notice.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.notice.dto.Notice;

public class NoticeDetailController extends NoticeController{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답형식
		response.setContentType("application/json;charset=utf-8");

		//크로스오리진 문제해결 DispatcherServlet으로 이사감

		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); //잭슨 라이브러리 불러오기

		//요청전달데이터 얻기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		try {
			Notice p = service.findByNoticeNo(noticeNo);
			String jsonStr = mapper.writeValueAsString(p); //라이브러리사용
			out.print(jsonStr);
		} catch (FindException e) {
			e.printStackTrace();
			//out.print("{\"msg\":\"" + e.getMessage() + "\"}");
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			out.print(jsonStr);
		}
		//return "productlistresult.jsp"; <- 만약 MVC구조로 만들어서 jsp페이지로 이동할 경우
		return null;
	}
}
