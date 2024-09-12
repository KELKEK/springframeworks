package com.shinhan.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;


public class LoginCheckFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginCheckFilter() {
        super();
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		HttpSession session = req.getSession();

		
		//webshop/auth/login.do 이런식으로 URI가 옴
		if(!req.getRequestURI().endsWith("login.do")) {
			System.out.println("쿼리 스트링!!!" + req.getQueryString());
			session.setAttribute("lastRequest", req.getRequestURI());
			//get방식이 적용된 원래 페이지로 돌아가게 할 수 있는 역할(getQueryString)	
			session.setAttribute("queryString", req.getQueryString()); 
		
			EmpDTO emp = (EmpDTO)session.getAttribute("emp");
			//泥섏쓬�뿉�뒗 諛붾줈 濡쒓렇�씤媛믪쓣 紐삳컺�븯湲� �븣臾몄뿉 濡쒓렇�씤李쎌뿉�꽌遺��꽣 �떆�옉�븯寃� �맖
			if(emp == null) {
				//濡쒓렇�씤 �릺�뼱�엳吏� �븡�쑝硫� 釉뚮씪�슦��濡� �궡�젮媛��꽌 濡쒓렇�씤李쎌쑝濡� �옱�슂泥��븿
				String path = req.getContextPath();
				System.out.println("filter...path=>" + path);
				rep.sendRedirect(path + "/auth/login.do");
				return;
			}
		
			
		}
		//pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
