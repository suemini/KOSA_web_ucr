package com.kosa.ucr.course.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.course.dto.Course;

public class SearchController extends CourseController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		//요청전달데이터 얻기	
		String proName = request.getParameter("proName");
		String mName = request.getParameter("mName");
		String coName = request.getParameter("coName");
		String coDay = request.getParameter("coDay");
		String condition = "";

		if (coDay.equals("All") && (mName.equals("All") || mName.equals("")) && proName.equals("") && coName.equals("") ) {
		    condition = "c.co_code IS NOT NULL";
		} else if (proName != null && proName !="") {
		    condition = "INSTR(pro_name, '" + proName + "') > 0";
		} else if (mName != null && !mName.equals("All") && !mName.equals("")) {
		    condition = "m_name = '" + mName + "'";
		} else if (coName != null && coName !="") {
		    condition = "INSTR(co_name, '" + coName + "') > 0";
		} else if (coDay != null && coDay !="") {
		    condition = "INSTR(co_day, '" + coDay + "') > 0";
		} 

		Map<String, Object> map = new HashMap<>();
		try {
		    Map<String, String> params = new HashMap<>();
		    params.put("condition", condition);
		    List<Course> list = service.searchCourses(params);	    
		    map.put("status", 1);
		    map.put("list", list);
		    
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", e.getMessage());
				
		}
		String jsonStr = mapper.writeValueAsString(map);
		out.print(jsonStr);
		return null;
	}
}
