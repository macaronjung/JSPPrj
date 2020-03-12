package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Add", "/add" })
public class Add extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//22강 과제풀이
			//인코딩 변환
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			//일단 오는 것을 String으로 받음(주는게 String 값이라서)
			//인트값에 변수 x를 설정하기 위해 임시변수 사용
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");
			
			//사용자가 빈문자열을 보낼수도 있음
			//그러면 값을 0으로 처리
			int x = 0;
			int y = 0;
			
			//공백값이 아니면 x값을 내가 원하는 값으로 바꾸자(지금은 임시변수에 저장)
			if(!x_.equals("")) x = Integer.parseInt(x_);
			if(!y_.equals("")) y = Integer.parseInt(y_);
			
			int result = x + y;
			
			//클라이언트에 출력시키기
			//PrintWriter out = response.getWriter();
			response.getWriter().printf("result is %d\n", result);
		
	}

}
