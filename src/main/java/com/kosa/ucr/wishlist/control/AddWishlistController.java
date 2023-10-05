package com.kosa.ucr.wishlist.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.AddException;

public class AddWishlistController extends WishlistController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//크로스오리진 문제해결 DispatcherServlet으로 이사감
		//응답형식
		response.setContentType("application/json;charset=utf-8");
		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		//json용 lib사용
		ObjectMapper mapper = new ObjectMapper(); 
		String jsonStr;
		//반환용 Map객체생성
		Map<String, Object> map = new HashMap<>();
		
		//1. 요청전달데이터 얻기(로그인된 학번이용, 클릭하면 학수번호(coCode)받아서와서 추가할 것
		//2. HttpSession객체얻기
		HttpSession session = request.getSession();
		Integer loginedId = (Integer) session.getAttribute("loginedId");
		String coCode = request.getParameter("coCode");
			
		if(loginedId == null) {
			map.put("status", 0);
			map.put("msg", "희망강좌를 담기 전에 로그인을 해주세요");
		}else {
			try {
				service.addWishlist(coCode, loginedId);
				map.put("status", 1);
				map.put("msg", "희망강좌 수강신청 성공");
			} catch (AddException e) {
				e.printStackTrace();
				map.put("status", 0);
				map.put("msg", "희망강좌 수강신청 실패" + e.getMessage());
			}			
		}

		out.print(mapper.writeValueAsString(map));
		return null;
	}

}
