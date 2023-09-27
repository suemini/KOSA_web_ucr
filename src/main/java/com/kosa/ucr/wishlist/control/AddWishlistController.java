package com.kosa.ucr.wishlist.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.wishlist.dto.Wishlist;

public class AddWishlistController extends WishController {

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
		String coCode = request.getParameter("coCode");
		int stuId = Integer.parseInt(request.getParameter("stuId")); //로그인 전에는 세션데이터 못 받아오니까 back만 실험하기 위해서 아래구문을 이걸로 대체함
//		Student s = new Student();
//		int stuId = s.getStuId();
		System.out.println(coCode + ":" + stuId);
		
		//2. HttpSession객체얻기
		HttpSession session = request.getSession();
		
		//3. session객체의 attribute값(이름:cart) 얻기 
		//Map<String, Integer> cart = (Map)~~
		Map<String, Integer> wish = (Map)session.getAttribute("wish");
		//4. Attribute가 없으면 객체생성 후 어트리뷰트로 추가
		if(wish == null) {
			wish = new TreeMap<String, Integer>();
			session.setAttribute("wish", wish);
		}
		//3,4번 내가 만들었지만 그냥 있길래 넣었을 뿐 세션이 왜 필요할까 싶기도 어차피 바로 DB에 넣는데...왜지...
		
		//5. 요청전달데이터 상품번호를 Key, 수량을 value로 어트리뷰트의 요소로 추가한다
		//stuId의 학생이 coCode를 갖고 있지 않은 경우에만 추가할 필요 없음 어차피 이전에 한 거 있으면 당연히 세션 다를테니까
		
		Wishlist wl = new Wishlist();
		wl.setStuId(stuId);
		wl.setCoCode(coCode);
		try {
			service.addWishlist(wl);
			map.put("status", 1);
			map.put("msg", "희망강좌 수강신청 성공");
		} catch (AddException e) {
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", "희망강좌 수강신청 실패" + e.getMessage());
		}

		out.print(mapper.writeValueAsString(map));
		
		return null;
	}

}
