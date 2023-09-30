package com.kosa.ucr.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String envFileName = "com.kosa.ucr.control.properties";
	private Properties env;

	public DispatcherServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		env = new Properties();
		ServletContext sc = this.getServletContext();
		String realPath = sc.getRealPath("WEB-INF\\classes\\com\\kosa\\ucr\\env\\" + envFileName);
		System.out.println("in DispatcherServlet의 init(): realPath=" + realPath);
		try {
			env.load(new FileInputStream(realPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:5500");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		System.out.println("request.getServletPath()=" + request.getServletPath());
		String className = env.getProperty(request.getServletPath());
		System.out.println(className);
		
		//singleton으로 맞춘 경우
		/* java.lang.ExceptionInInitializerError
		try {
			Class<?> clazz = Class.forName(className); 
			Controller controller;
			try {
				Method method = clazz.getMethod("getInstance");
				controller = (Controller)method.invoke(null);//static인 getInstance()메서드호출
			}catch(NoSuchMethodException e) {			
				controller = (Controller)clazz.getDeclaredConstructor().newInstance();
			}
			String path = controller.execute(request, response);
			if(path != null) {
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		} catch (InvocationTargetException e) {
		    // 내부 예외를 확인하고 처리
		    Throwable cause = e.getCause();
		    if (cause != null) {
		        cause.printStackTrace();
		    } else {
		        e.printStackTrace();
		    }
		} catch (Exception e1) {
			e1.printStackTrace();
		} */
		
		/* java.lang.reflect.InvocationTargetException */
		try {
			Class<?> clazz = Class.forName(className);//클래스이름에 해당하는 .class파일 찾아서 JVM으로 로드
			
			Controller controller;
			try {
				Method method = clazz.getMethod("getInstance");
				controller = (Controller)method.invoke(null);//static인 getInstance()메서드호출
			}catch(NoSuchMethodException e) {			
				controller = (Controller)clazz.getDeclaredConstructor().newInstance();
			}
			String path = controller.execute(request, response);
			if(path != null) {
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		/* Controller 싱글톤으로 안 맞춰준 경우
		try {
			Class clazz = Class.forName(className); //클래스이름에 해당하는 .class파일 찾아서 JVM으로 로드
			Controller controller = (Controller)clazz.getDeclaredConstructor().newInstance(); 
			//clazz.newInstance(); //지금 로드된 클래스타입의 객체생성 newInstance디프리케이티드돼서 위로 바꿈
			controller.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
