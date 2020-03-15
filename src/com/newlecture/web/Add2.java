package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Add2", "/add2" })
public class Add2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			//24강 동일한 이름을 가진 여러가지 파라미터를(배열)을 받는 것
			String[] num_ = request.getParameterValues("num");
			
			//24강 기본값 설정
			int result = 0;
			
			//24강 반복문 이용 값 처리하기
			for(int i=0; i<num_.length; i++) {
				//24강 num이 가지고 있는 값을 숫자로 바꿔야함
				//for문 안에서 연산은 반복되지만 선언은 반복되지 않음
				//지역변수 설정 + i 변수이용 파싱(특정한 내용 추출)
				//파싱(parsing):어떤 페이지(문서, html 등)에서 내가 원하는 데이터를
				//특정 패턴이나 순서로 추출해 가공하는 것
				int num = Integer.parseInt(num_[i]);
				result += num;
			}
			
			response.getWriter().printf("result is %d\n", result);
	}

}
