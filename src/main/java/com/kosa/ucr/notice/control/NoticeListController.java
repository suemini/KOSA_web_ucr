package com.kosa.ucr.notice.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.notice.dto.Notice;
import com.kosa.ucr.notice.dto.PageGroup;


public class NoticeListController extends NoticeController{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		//응답형식
		response.setContentType("application/json;charset=utf-8"); //text/html아님


		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();

		//요청전달데이터 currentPage얻기
		String currentPage = request.getParameter("currentPage");
		int cp = 1;
		if(currentPage != null && !currentPage.equals("")) {
			cp = Integer.parseInt(currentPage);
		}
		try {
			PageGroup<Notice> pg = service.findAll(cp);
			String jsonStr = mapper.writeValueAsString(pg);
			out.print(jsonStr);
		} catch (FindException e) {
			e.printStackTrace();
		}
		return null;
	}
}
