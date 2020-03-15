package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Calc", "/calc" })
public class Calc extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			/* getParameter()메서드의 경우 String타입을 리턴
			   getAttribute()는 Object 타입을 리턴하기 때문에 주로 빈 객체나 다른 클래스를 받아올때 사용

			   getParameter()는 웹브라우저에서 전송받은 request영역의 값을 읽어오고
			   getAttribute()의 경우 setAttribute()속성을 통한 설정이 없으면 무조건 null값을 리턴

				request.getParameter("num")은 웹브라우저에서 전송받은 request영역에서 name값이 "num"인것을 찾아 그 값을 읽어오는데
				request.getAttribute("num")은 request.setAttribute("num", "123") 과 같이 setAttribute()를 통해 값을 설정해주지 않으면 null값을 리턴
			 * 
			 * http://hsprnote.blogspot.com/2017/03/jsp-getparameter-getattribute.html
			 * */
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");
			//23강 operator에게 변수 선언
			String op = request.getParameter("operator");
			

			int x = 0;
			int y = 0;
			
			//공백값이 아니면 x값을 내가 원하는 값으로 바꾸자(지금은 임시변수에 저장)
			if(!x_.equals("")) x = Integer.parseInt(x_);
			if(!y_.equals("")) y = Integer.parseInt(y_);
			
			//23강 기본값 초기화
			int result = 0;
			
			//23강 if문으로 조건 선택하기
			if(op.equals("덧셈")) {
				result = x + y;
			}	else {
				result = x - y;
			}
				
			//클라이언트에 출력시키기
			//PrintWriter out = response.getWriter();
			response.getWriter().printf("result is %d\n", result);
		
	}

}
