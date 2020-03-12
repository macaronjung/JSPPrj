package com.newlecture.web;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/AddEX")
public class AddEx extends HttpServlet {
	/* 저 결과값을 어떻게 넘겨줄지 모르겠음...
	 * protected Add(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * 
	 * response.setCharacterEncoding("utf-8");
	 * response.setContentType("text/html; charset=utf-8");
	 * 
	 * int x = Integer.parseInt(request.getParameter("x")); int y =
	 * Integer.parseInt(request.getParameter("y"));
	 * 
	 * int result = x + y; }
	 * 
	 * 애초에 만들때 doGet,doPost를 해제하고 service만 체크
	 */
	
}
