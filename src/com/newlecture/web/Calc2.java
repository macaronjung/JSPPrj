package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//어노테이션 수정 반드시 실시!!!
@WebServlet({ "/Calc2", "/calc2" })
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ServletContext application = request.getServletContext();
			HttpSession session = request.getSession();
			//29강 사용자가 보낸 쿠키 읽게 만들기
			//읽어올때 배열로 읽어옴!!!(getCookies)
			Cookie[] cookies = request.getCookies();
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String v_ = request.getParameter("v");
			String op = request.getParameter("operator");
			
			int v = 0;
			if(!v_.equals("")) v = Integer.parseInt(v_);
			
			if(op.equals("=")) {
				//어플리케이션 객체 사용한 것 주석처리
				//int x = (Integer)application.getAttribute("value");
				//int x = (Integer)session.getAttribute("value");
				int x = 0;
				//29강 쿠키 이용 첫번째 값 꺼내기
				//Cookie c = cookies[0];
				
				//for 이용 값들 꺼내기->쿠키라는 녀석을 찾기
				for(Cookie c : cookies) 
				//꺼낸 값의 이름이 우리가 심은 조건과 같은지 비교(이름으로 검색)
				//if(c.getName().equals("value")); -> 멋대로 마침표 찍어놔서 오류 나왔었음
				if(c.getName().equals("value")) {
					//조건에 맞으면 이 값을 사용
					//단, getValue는 String 값 반환(인티거 이용할 것)
					//x = c.getValue();
					//java.lang.NumberFormatException: For input string: "value"
					//getName이 아닌 getValue 사용해야함!
					x = Integer.parseInt(c.getValue());
					//값을 찾았으면 나와야지
					break;
					}
				
				
				int y = v;
				//String operator = (String)application.getAttribute("op");;
				//String operator = (String)session.getAttribute("op");;
				
				//간편하게 구현하기
				String operator = "";
				for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
					}
				
				int result = 0;
				
				if(operator.equals("+")) 
					result = x + y;
			    else 
				    result = x - y;
					response.getWriter().printf("result is %d\n", result);
				
			} else {
				//application.setAttribute("value", v);
				//application.setAttribute("op", op);
				//session.setAttribute("value", v);
				//session.setAttribute("op", op);
				
				//29강 cookie 이용 상태값 유지
				//cookie 사용시 보내는 값은 무조건 URL이 사용할 수 있는
				//문자열만 가능!!!
				//String.valueOf()로 문자열 변환
				Cookie valueCookie = new Cookie("value", String.valueOf(v));
				Cookie opCookie = new Cookie("op", op);
				//쿠키 두개를 만든 것 뿐이고 클라이언트에게 보내야됨!
				//쿠키를 클라이언트에게 보내기
				response.addCookie(valueCookie);
				response.addCookie(opCookie);
				//리스폰스 헤더에 심어져서 보내짐
			}

	}

}
