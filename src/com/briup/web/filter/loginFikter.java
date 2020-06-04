package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.briup.bean.User;

/**
 * Servlet Filter implementation class loginFikter
 */
@WebFilter("/user/*")
public class loginFikter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFikter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     HttpServletRequest req=(HttpServletRequest) request;
     HttpSession session = req.getSession();
     User user = (User) session.getAttribute("loginUser");
     if(user==null)
     {
    	 HttpServletResponse resp= (HttpServletResponse) response;
    	 resp.sendRedirect("/estore/login.jsp");
     }
     else {
    		chain.doFilter(request, response);
     }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
