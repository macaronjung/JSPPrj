package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 20강 필터를 설정만 하면 필터값이 자동으로 작동(톰캣 처음 실행시에도 실행)
// @WebFilter("매핑되는 주소") -> xml 설정 변경없이 필터 적용 가능
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 20강 web.xml 443 줄 부터 -> xml 이용 필터사용
		
		// 20강 filter는 출력되지만 NoticeReg 내용은 출력이 안됨
		// sout 실행 후 
		// 요청이 서블릿을 실행시키는 쪽으로 넘길지 여부 결정 -> FilterChain chain
		// 20강 요청이 오면 흐름을 넘김 -> 다음 필터나 서블릿으로
		//chain.doFilter(request, response);
					
		// 다음 필터나 서블릿이 실행되기 전 실행됨!
		//System.out.println("before Filter");
		request.setCharacterEncoding("utf-8");	
		// 다음 실행을 어디로 가게 할건지 정하는 조건
		chain.doFilter(request, response);
		// 다음 필터나 서블릿이 실행된 후 실행됨!
		//System.out.println("after Filter");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
