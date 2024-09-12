package com.shinhan.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//요청주소연습
@Controller
@RequestMapping("/sample") //공통적인 path는 class level에서 정의, 각각은 method level에 작성한다.
public class SampleController {
	
	@RequestMapping("hello.do")
	public String test1() {
		return "jsp/hello";
		//접두사/접미사 붙음
	}
	
	@RequestMapping("/hello1.do") //맨 앞의 슬래시는 넣어도 되고 안넣어도 된다.
	public String test2() {
		return "jsp/hello";
		//얘도 같은 곳으로 간다.
	}
	
	@RequestMapping(value = {"hello2.do","hello3.do"}, method = RequestMethod.GET)
	public String test3() {
		return "jsp/hello";
		//얘도 같은 곳으로 간다.
	}
	
	
	@GetMapping("hello4.do")
	public String test4(Model data) {
		data.addAttribute("myname", "신한DS");
		data.addAttribute("myscore", 100);
		return "jsp/hello";
	}
	
	@GetMapping("hello5.do")
	public ModelAndView test5() {
		//ModelAndView data = new ModelAndView("jsp/hello");
		ModelAndView data = new ModelAndView();
		data.setViewName("jsp/hello");
		data.addObject("myname", "신한DS");
		data.addObject("myscore", 99);
		return data;
	}
	
	@RequestMapping(value="hello6.do", 
			method = RequestMethod.GET,
			params={"email", "pwd=1234", "!address"}) //존재, 일치, 존재X
	public String test6(Model model, @RequestParam("email") String email2, String pwd, String phone) {
		//@RequestParam은 생략 가능 => request.getParameter("email")
		System.out.println("=======/hello6.do======");
		System.out.println(email2);
		System.out.println(pwd);
		System.out.println(phone);
		model.addAttribute("lunch", "오늘 메뉴는?삼겹살");
		return "jsp/hello6";
	}
	
	//@RequestMapping(value="/hello6.do", method=RequestMethod.POST)
	@PostMapping("hello6.do")
	public String test7(
			String email,
			@RequestParam(value = "pwd", required = true) String pwd,
			String phone) {// required 기본값은 false
		//default => 접두사+"/sample/hello6.jsp" + 접미사
		return null;
	}
}
