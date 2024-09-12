package com.shinhan.myapp.section6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service : 비지니스 로직 작성
//Service = @Component + 서비스역할
@Service("bService")
 public class BoardService {
	
	
	//타입이 같으면 객체를 Injection한다.
	@Autowired
	BoardDAO boradDao;
	
	public int deleteBoard(int bno) {
		return boradDao.deleteBoard(bno);
	}
	
	public int updateBoard(BoardDTO board) {
		return boradDao.updateBoard(board); 
	}
	
	public int insertBoard(BoardDTO board) {
		 return boradDao.insertBoard(board);
	}
	
	
	public BoardDTO selectById(int bno) {
		 return boradDao.selectById(bno);
	}
	
	
	public List<BoardDTO> selectAll() {
		 return boradDao.selectAll();
	}

	 
}


