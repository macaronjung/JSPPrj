package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//어노테이션 수정 반드시 실시!!!
@WebServlet({ "/Calc2", "/calc2" })
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//어플리케이션->말 그대로 어플리케이션 전역에 사용가능
			ServletContext application = request.getServletContext();
			//27강 세션 객체로 상태 값 저장
			//세션->세션 범주 내(현재 접속한 사용자)에서 사용가능
			//사용자 별로 내용이 달라질 수 있음
			//최근 프로그램은 프로세스를 다중으로 실행하지 않고 하위 쓰레드로 처리
			//->크롬에서 작업했으면 세션이 크롬에 남아있음
			//세션 변수화
			HttpSession session = request.getSession();
			
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String v_ = request.getParameter("v");
			//오퍼레이터에 따라 저장할 수도 계산할수도 있음
			String op = request.getParameter("operator");
			
			int v = 0;
			if(!v_.equals("")) v = Integer.parseInt(v_);
			
			if(op.equals("=")) {
				//어플리케이션 객체 사용한 것 주석처리
				//int x = (Integer)application.getAttribute("value");
				int x = (Integer)session.getAttribute("value");

				int y = v;
				//String operator = (String)application.getAttribute("op");;
				String operator = (String)session.getAttribute("op");;
				int result = 0;
				
				if(operator.equals("+")) 
					result = x + y;
			    else 
				    result = x - y;
					response.getWriter().printf("result is %d\n", result);
				
			} else {
				//application.setAttribute("value", v);
				//application.setAttribute("op", op);
				session.setAttribute("value", v);
				session.setAttribute("op", op);
			}

	}

}
