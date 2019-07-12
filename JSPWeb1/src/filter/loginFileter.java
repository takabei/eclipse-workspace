package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damain.User;



/**
 * Servlet Filter implementation class loginFileter
 */
public class loginFileter implements Filter {

   
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		User user = (User) req.getSession().getAttribute("SessionUser");
		if(user == null) {
			req.setAttribute("err", "请先登录!");
			req.getRequestDispatcher("/user/Login.jsp").forward(req, resp);
		}
		chain.doFilter(request, response);
	}

	

}
