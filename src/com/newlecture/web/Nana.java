package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

// 처음에 그냥 치면 오류 뜨고 서블릿 자동완성 안됨
// 서버 연결을 해줘야됨!!!
// Project Facets → Java → Apache Tomcat v8.5 체크 
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 매핑정보가 없기 때문에 404에러 발생(12강)
// 12강 어노테이션 사용
@WebServlet("/hi")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 13강 한글 깨짐 방지 코드
		// 이래도 깨지면 브라우저 인코딩 방식 변경
		// 기본 세팅 값 : EUC-KR
		response.setCharacterEncoding("utf-8");
		
		// 14강 받은 값이 어떤 값인지 설정해 주는 코드
		// 이 녀석은 html 형식이고
		// 위에서 utf-8로 보내니까 너는 utf-8로 읽어라
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 16강 쿼리스트링 작성
		String cnt_ = request.getParameter("cnt");
		// 주소 뒤에 ?cnt=숫자 로 반복 횟수 조절 가능
		int cnt = 10;
		// 널값이 아니면서 빈 문자열이 아닌 것 검사
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(request.getParameter("cnt"));
		
		// 15강 브라우저 마다 다르게 인식(띄어쓰기 등)
		// 브라우저가 웹문서로 인식->html 언어를 사용해야함!!!
		// 강제적으로 <br> 태그 삽입시 브라우저가 자의적으로 해석
		// IE : html / chrome : text (컨텐츠 형식 알려주지 않은 경우)
		for (int i = 0; i < cnt; i++) {
			out.println((i+1) + ":" + "안녕 Hello Servlet~!~!~!~");
		}

	}
}
