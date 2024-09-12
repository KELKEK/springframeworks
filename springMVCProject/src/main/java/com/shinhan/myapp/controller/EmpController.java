package com.shinhan.myapp.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.util.DateUtil;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpService eService;
	// 같은 타입이 여러 개 있으면 이름을 비교해서 같은 이름의 bean을 Injection

	@Autowired
	DeptService dService;

	// deptSelect=0&jobSelect=all&...
	// deptSelect = 0은 전체를 의미
	@RequestMapping("/empAll2.do")
	public String empAll(Model model, Integer deptSelect, String jobSelect, String hdate, Integer salary, HttpSession session) {
		Date startDate = DateUtil.getSQLDate(hdate);
		List<EmpDTO> emplist2 = eService.selectByCondition(deptSelect, jobSelect, startDate, salary);
		//선택한 값들을 session에 저장하기
		System.out.println(deptSelect);
		System.out.println(jobSelect);
		System.out.println(startDate);
		System.out.println(salary);
		session.setAttribute("deptSelect", deptSelect);
		session.setAttribute("jobSelect", jobSelect);
		session.setAttribute("hdate", hdate);
		session.setAttribute("salary", salary);
		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("joblist", eService.selectAllJob());
		return "emp/emplist";
	}

	@RequestMapping("/empAll.do")
	public String empAll(Model model, Integer deptid, String jobid) {
		List<EmpDTO> emplist2 = null;

		// 부서선택인 경우
		if (deptid == null && jobid == null) {
			emplist2 = eService.selectAll();
		} else {
			// 부서조회
			if (deptid != null && jobid == null) {
				if (deptid == 0) {
					emplist2 = eService.selectAll();
				} else {
					emplist2 = eService.selectByDept(deptid);
				}
			} else {
				// 직책조회
				if (jobid.equals("all")) {
					emplist2 = eService.selectAll();
				} else {
					emplist2 = eService.selectByJob(jobid);
				}
			}
		}
		
		
		// 직책선택인 경우
		// 전부조회인 경우
		
		
		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("joblist", eService.selectAllJob());
		// view�씠由꾩씠 return�맂�떎.
		// ViewResolver媛� �젒�몢�궗+view�씠由�+�젒誘몄궗
		// view濡� forward�맂�떎(二쇱냼�뒗 諛붾�뚯� �븡�쓬)
		return "emp/emplist";
	}

	@GetMapping("/empDetail.do")
	public void detail(Integer empid, Model model) { // empid는 emplist에서 받은 empid와 같은 이름의 변수값이어야 한다.
		model.addAttribute("empInfo", eService.selectByID(empid));
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("joblist", eService.selectAllJob());
	}

	// 입력창보여주기
	@GetMapping("/empInsert.do")
	public String insert(Model model) {
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("joblist", eService.selectAllJob());
		// 선택창을 넣었던 것도 넣을 수 있게 위의 목록들을 추가로 반영해서 addAttribute해줘야 한다.
		return "emp/empInsert";
	}

	// DB에 입력하기
	@PostMapping("/empInsert.do")
	public String insertUpdate(EmpDTO emp) {
		eService.empInsert(emp);
		return "redirect:empAll.do";
	}

	// 수정
	@PostMapping("/empDetail.do")
	public String update(EmpDTO emp) {
		System.out.println(emp);
		eService.empUpdate(emp);
		return "redirect:empAll.do";
	}

	// 삭제
	@GetMapping("/empDelete.do")
	public String delete(Integer empid) {
		eService.empDelete(empid);
		return "redirect:empAll.do";
	}

	// 중복체크
	@GetMapping("/empIdCheck.do")
	@ResponseBody
	public String test(Integer empid) {
		EmpDTO emp = eService.selectByID(empid);
		if (emp == null) {
			return "0";
		}
		return "1";
	}
	/*
	 * @ResponseBody response.getWriter().append("1")
	 */
	
	

}
