package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.jsp")
public class TestFilter extends HttpFilter implements Filter {
    public TestFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		// pre-process 
		System.out.println(httpRequest.getRequestURL());
		chain.doFilter(request, response); // call endpoint 
		// post-process 
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
