package com.kosa.ucr.control;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.ucr.student.dto.Student;

public class AddWishlistController extends WishController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//크로스오리진 문제해결 DispatcherServlet으로 이사감
		//응답형식
		response.setContentType("application/json;charset=utf-8");
		
		//1. 요청전달데이터 얻기(로그인된 학번이용, 클릭하면 학수번호(coCode)받아서와서 추가할 것
		String coCode = request.getParameter("coCode");
		int stuId = Integer.parseInt(request.getParameter("stuId")); //로그인 전에는 세션데이터 못 받아오니까 back만 실험하기 위해서 아래구문을 이걸로 대체함
//		Student s = new Student();
//		int stuId = s.getStuId();
		
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
		
		//5. 요청전달데이터 상품번호를 Key, 수량을 value로 어트리뷰트의 요소로 추가한다
		//stuId의 학생이 coCode를 갖고 있지 않은 경우에만 추가할 필요 없음 어차피 이전에 한 거 있으면 당연히 세션 다를테니까
		wish.put(coCode, stuId);
		session.setAttribute("wish", wish);
		
		//6. 어트리뷰트 요소들을 모두 출력한다
		for(String key: wish.keySet()){ //keySet 저장된 key값 확인
			int value = wish.get(key);
			System.out.println( key + ": " + value);
		}
		
		return null;
	}

}
