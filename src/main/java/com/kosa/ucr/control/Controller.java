package com.kosa.ucr.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 인터페이스는 무조건 public 객체생성이 안되서 이렇게
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
