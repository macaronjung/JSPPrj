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

// 이 URL을 책임지는 서블릿 코드라는 의미
@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
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
		
		// 18강 전달받는 값의 이름(네임)을 수정
		// 이 값을 DB에 저장하거나 파일에 추출할 수도 있음
		// 지금은 잘 받았다는 것만 확인
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		out.println(title);
		out.println(content);
		//문제점 1 : 전달된 내용이 쿼리스트링으로 전달됨
		//문제점 2 : 내용이 길어지면 URL이 길어짐(길이 제한이 있음!!!)
		//문제점 3 : 쿼리스트링은 문서에 대한 옵션값임(장문의 내용은 보내는 것이 아님!)
	}
}
