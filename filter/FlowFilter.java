package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter("/firstone")
/* 이클라이언트는 웹필터로부터 firstone이 호출될때 사용된다. */

public class FlowFilter implements Filter {   
    public FlowFilter() {
        System.out.println("FlowFilter 객체 생성");
    }

	public void destroy() { //서버 죽을때
		System.out.println("FlowFilter 객체 삭제");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("서블릿 수행전.....");
		chain.doFilter(request, response);
		System.out.println("서블릿 수행후.....");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FlowFilter 객체 초기화");
	}

}
