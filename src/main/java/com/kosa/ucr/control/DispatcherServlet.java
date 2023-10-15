package com.kosa.ucr.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String envFileName = "control.properties";
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
//		response.setHeader("Access-Control-Allow-Origin", "http://192.168.1.자기숫자:5500");
		response.setHeader("Access-Control-Allow-Origin", "http://172.30.1.1:5500");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		System.out.println("request.getServletPath()=" + request.getServletPath());
		String className = env.getProperty(request.getServletPath());
		System.out.println(className);
		try {
			Class clazz = Class.forName(className);
			Controller controller = (Controller) clazz.getDeclaredConstructor().newInstance();
			controller.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
