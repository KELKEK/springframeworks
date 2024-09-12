package com.shinhan.myapp.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService bService;

	@RequestMapping("/selectAll.do")
	public String test1(Model model) {
		System.out.println("/board/selectAll.do요청");
		List<BoardDTO> blist = bService.selectAll();
		model.addAttribute("blist", blist);
		return "board/boardlist"; // forward됨 -> 접두사+"board/boardlist"+접미사
	}

	@GetMapping("/boardinsert.do")
	public void test2(String title, String content, String pic) {
		// forward : 접두사+"board/boardinsert"+접미사
	}

	// @PostMapping("/boardInsert.do")
	public String test3(BoardDTO board, RedirectAttributes attr) {
		int result = bService.insertBoard(board);
		String message;
		System.out.println(board);
		// redirect : 요청을 위임
		// forward : 재요청
		// BoardDTO board = new BoardDTO(0, title, content, "작성자", pic, null);
		if (result > 0) {
			message = "insert success";
		} else {
			message = "insert fail";
		} // update, delete문법도 동일하게 적용 가능하다(return값이 int형태이기 때문), RedirectAttributes 넣는 것
			// 잊지말기
		attr.addFlashAttribute("resultMessage", message);
		return "redirect:selectAll.do";
	}

	@PostMapping("/boardInsert.do")
	public String test3(MultipartHttpServletRequest multipart, HttpSession session) throws UnsupportedEncodingException {
		BoardDTO board = new BoardDTO();
		HttpServletRequest request = (HttpServletRequest) multipart;
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		EmpDTO emp = (EmpDTO)session.getAttribute("emp");
		String writer = null;
		if(emp == null) {
			writer = "손님";
		}else {
			writer = emp.getFirst_name() + emp.getLast_name();
		}
		List<MultipartFile> fileList = multipart.getFiles("pic");
		String path = request.getSession().getServletContext().getRealPath("./resources/uploads"); //여기로 업로드함
		File fileDir = new File(path); //해당 uploads 디렉터리가 존재하지 않으면 만들어서 넣는다는 뜻
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		long time = System.currentTimeMillis();
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); //
			String saveFileName = String.format("%d_%s", time, originFileName);
			board.setPic(saveFileName);
			try {
				//upload하기
				mf.transferTo(new File(path, saveFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("board:" + board);
		bService.insertBoard(board);
		// forward:요청을 위임
		// redirect:재요청
		return "redirect:selectAll.do";
	}

	@GetMapping("/boardDetail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("board", bService.selectById(bno));
		return "board/boarddetail";
	}

	@PostMapping("/boardDetail.do")
	public String update(BoardDTO board) {
		bService.updateBoard(board);
		return "redirect:selectAll.do";
	}

	// @RequestMapping(value="/boardDelete.do", method = RequestMethod.GET)
	@GetMapping("/boardDelete.do")
	public String delete(Integer bno) {
		bService.deleteBoard(bno);
		return "redirect:selectAll.do";
	}

	@GetMapping("/selectDelete.do")
	public String selectDelete(Integer[] checkBno) {
		// 선택된 내용들을 삭제하기 위함
		System.out.println(Arrays.toString(checkBno));
		int result = bService.deleteBoardArray(checkBno);
		return "redirect:selectAll.do";
	}
}
