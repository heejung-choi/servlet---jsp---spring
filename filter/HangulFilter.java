package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
/* 이클라이언트는 웹필터로부터 firstone이 호출될때 사용된다. */

public class HangulFilter implements Filter {   
	public void destroy() { //서버 죽을때
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("HangulFilter 수행 - BEFORE");
		if(((HttpServletRequest)request).getMethod().equals("POST"))//post 방식이면 utf-8을 처리한다.
			request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		System.out.println("HangulFilter 수행 - AFTER");
	}
	public void init(FilterConfig fConfig) throws ServletException {	
	}

}
