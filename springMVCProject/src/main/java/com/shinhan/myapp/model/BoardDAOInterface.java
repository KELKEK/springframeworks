package com.shinhan.myapp.model;

import java.util.List;

public interface BoardDAOInterface {
	public List<BoardDTO> selectAll();
	public BoardDTO selectById(int bno);
	public int insertBoard(BoardDTO board);
	public int updateBoard(BoardDTO board);
	public int deleteBoard(int bno);
}
