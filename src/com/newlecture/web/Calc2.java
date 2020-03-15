package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 수정 반드시 실시!!!
@WebServlet({ "/Calc2", "/calc2" })
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//26강 값을 저장하는 녀석은 무엇??
			//어플리케이션 저장소(v_ 와 op 를 저장할 공간)
			ServletContext application = request.getServletContext();
		
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String v_ = request.getParameter("v");
			//오퍼레이터에 따라 저장할 수도 계산할수도 있음
			String op = request.getParameter("operator");
			
			int v = 0;
			if(!v_.equals("")) v = Integer.parseInt(v_);
			
			//일단 op의 역할 설정하기->계산하기
			if(op.equals("=")) {
				//x값 앞에서 저장했던값(저장소에서 꺼낸 값)
				//저장소에 값을 저장하는 것 말고도 값을 꺼내오는 작업을 해야됨
				//그냥 쓰면 오류 남->값을 오브젝트로 값을 반환하기 때문에
				//int x = application.getAttribute("value");
				//래퍼 클래스로 해결
				int x = (Integer)application.getAttribute("value");
				//y값 지금 사용자가 전달한 밸류 값
				int y = v;
				//지금 저장한 값과 전달한 값을 가지고 덧셈을 할껀지
				//뺄셈을 할껀지 사용자가 지정한 값을 가지고 설정해야됨
				String operator = (String)application.getAttribute("op");;
				int result = 0;
				
				if(operator.equals("+")) {
					result = x + y;
				} else {
				    result = x - y;
				    //값을 출력->앞에서 저장했던 어플리케이션 값을 꺼내서 연산
					response.getWriter().printf("result is %d\n", result);
				}
			} else {
				//값을 저장하기(저장소에 담기)
				//키와 값을 설정(맵 컬렉션과 동일)-설정된 값을 저장(나중에 꺼내쓰겠다)
				application.setAttribute("value", v);
				application.setAttribute("op", op);
			}

	}

}
