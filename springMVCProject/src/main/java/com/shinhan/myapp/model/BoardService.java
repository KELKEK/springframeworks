package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //�����ϴ� ���̹Ƿ� ���� ("bService")�� ������ �����ϴ�. �Ŀ� @Qualifier�� ����ȴ�.
 public class BoardService {
	

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

	public int deleteBoardArray(Integer[] checkBno) {
		return boradDao.deleteBoardArray(checkBno);
		
	}
}


