package com.shinhan.myapp.section6;

import java.util.List;

import org.firstzone.section6.CompanyVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.myapp.section8.PhoneDTO;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di6.xml");
		
		CompanyVO comp1 = ctx.getBean("companyVO", CompanyVO.class);
		System.out.println(comp1);
		
		PhoneDTO b = ctx.getBean("my", PhoneDTO.class);
		System.out.println(b);
		
		BoardService service = ctx.getBean("bService", BoardService.class);
		List<BoardDTO> blist = service.selectAll();
		blist.stream().forEach(board->System.out.println(board));
	}

}
