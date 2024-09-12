package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	EmpService eService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login.do")
	public void loginDisplay() {
		logger.debug("login.do요청(debug)");
		logger.info("login.do요청(info)");
		logger.warn("login.do요청(warn)");
		logger.error("login.do요청(error)");
		
	}
	
	@PostMapping("/login.do")
	public String loginCheck(@RequestParam("email") String email, @RequestParam("pswd") String phone, HttpSession session, HttpServletRequest request) {
		EmpDTO emp = eService.loginChk(email, phone);
		System.out.println(emp);
		if(emp == null) {
			session.setAttribute("loginResult", "존재하지 않는 ID");
			System.out.println("존재하지 않는 ID");
			return "redirect:login.do";
			//mybatis로 변경하면서 jdbc에서는 -1: 존재하지 않은 ID, -2:password오류 <-이걸 적용시키지 않음(mybatis확인)
		}else if(!emp.getPhone_number().equals(phone)) {
			session.setAttribute("loginResult", "password 오류");
			System.out.println("password오류");
			return "redirect:login.do";
		}else {
			//로그인 성공
			session.setAttribute("loginResult", "로그인 성공");
			System.out.println("로그인 성공");
			session.setAttribute("emp", emp);
			String lastRequest = (String)session.getAttribute("lastRequest");
			String goPage;
			if(lastRequest==null) {
				//처음부터 로그인으로 간 경우
				goPage = "../dept/deptList.do";
			}else {
				//로그인 없이 다른 페이지로 요청한 경우
				int length = request.getContextPath().length();
				goPage = lastRequest.substring(length);
				String queryString = (String)session.getAttribute("queryString");
				//get방식이 적용된 원래 페이지로 돌아가게 할 수 있는 역할(getQueryString)
				if(queryString!=null) goPage = goPage+"?"+queryString;
				System.out.println("goPage =>" + goPage);
			}
			return "redirect:" + goPage;
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
}
