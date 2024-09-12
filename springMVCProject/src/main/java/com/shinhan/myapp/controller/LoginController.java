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
		logger.debug("login.do��û(debug)");
		logger.info("login.do��û(info)");
		logger.warn("login.do��û(warn)");
		logger.error("login.do��û(error)");
		
	}
	
	@PostMapping("/login.do")
	public String loginCheck(@RequestParam("email") String email, @RequestParam("pswd") String phone, HttpSession session, HttpServletRequest request) {
		EmpDTO emp = eService.loginChk(email, phone);
		System.out.println(emp);
		if(emp == null) {
			session.setAttribute("loginResult", "�������� �ʴ� ID");
			System.out.println("�������� �ʴ� ID");
			return "redirect:login.do";
			//mybatis�� �����ϸ鼭 jdbc������ -1: �������� ���� ID, -2:password���� <-�̰� �����Ű�� ����(mybatisȮ��)
		}else if(!emp.getPhone_number().equals(phone)) {
			session.setAttribute("loginResult", "password ����");
			System.out.println("password����");
			return "redirect:login.do";
		}else {
			//�α��� ����
			session.setAttribute("loginResult", "�α��� ����");
			System.out.println("�α��� ����");
			session.setAttribute("emp", emp);
			String lastRequest = (String)session.getAttribute("lastRequest");
			String goPage;
			if(lastRequest==null) {
				//ó������ �α������� �� ���
				goPage = "../dept/deptList.do";
			}else {
				//�α��� ���� �ٸ� �������� ��û�� ���
				int length = request.getContextPath().length();
				goPage = lastRequest.substring(length);
				String queryString = (String)session.getAttribute("queryString");
				//get����� ����� ���� �������� ���ư��� �� �� �ִ� ����(getQueryString)
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
