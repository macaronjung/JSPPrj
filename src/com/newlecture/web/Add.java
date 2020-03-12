package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Add", "/add" })
public class Add extends HttpServlet {

	//왜 service 메소드를 사용하는지 인터넷 검색결과
	//서블릿 생명주기 때문에 사용!!!
	/* 1.요청이 오면, Servlet 클래스가 로딩되어 요청에 대한 Servlet 객체가 생성
	 * 2.서버는 init() 메소드를 호출해서 Servlet을  초기화
	 * 3.service() 메소드를 호출해서 Servlet이 브라우저의 요청을 처리
	 * 4.service() 메소드는 특정 HTTP 요청(GET, POST 등)을 처리하는 메서드 (doGet(), doPost() 등)를 호출
	 * 5.서버는 destroy() 메소드를 호출하여 Servlet을 제거
	 * https://victorydntmd.tistory.com/154
	 * */
	/* 서블릿 의 service () 메소드는 클라이언트 요청에 대해 서블릿에 알리기 위해 호출
	 * ServletRequest 오브젝트를 사용 하여 클라이언트가 요청한 데이터를 수집
	 * 이 메소드는 ServletResponse 오브젝트를 사용하여 출력 컨텐츠를 생성 
	 * geeksforgeeks.org/life-cycle-of-a-servlet/
	 * */
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
