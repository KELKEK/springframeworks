package com.shinhan.myapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

//**정의하기
@Repository
public class BoardDAO {
	
	//**적용하기
	//타입이 같으면 자동 Injection
	//@Qualifier("dataSource")정의 <- 어딘가에 있는 정의된 이름을 불러옴, 같은 타입이 여러 개 있을 때 독자적인 이름으로 적용하기 위함, 생략 가능
	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	public int deleteBoard(int bno) {

		String sql = "delete from TBL_BOARD where bno=?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
		    result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}		
		return result;
	}
	
	public int updateBoard(BoardDTO board) {
		String sql = "update TBL_BOARD set title=?, content=?, pic=? "
				+ "where bno=?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getPic());
			pst.setInt(4, board.getBno());
		    result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}		
		return result;
	}
	
	public int insertBoard(BoardDTO board) {
		String sql = "insert into TBL_BOARD(bno, title, content, writer, pic) "
				+ " values(seq_board_bno.nextval,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic());
		    result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}		
		return result;
	}
	
	
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		String sql = "select * from TBL_BOARD where bno = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs); 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}		
		return board;
	}
	
	
	public List<BoardDTO> selectAll() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		String sql = "select * from TBL_BOARD";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO board = makeBoard(rs); 
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}		
		return boardList;
	}

	private BoardDTO makeBoard(ResultSet rs) throws SQLException {
		BoardDTO board = new BoardDTO();
		board.setBno(rs.getInt("bno"));
		board.setContent(rs.getString("content"));
		board.setCreate_date(rs.getDate("create_date"));
		board.setPic(rs.getString("pic"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		return board;
	}
	
	
	public int deleteBoardArray(Integer[] checkBno) {
		String sql = "delete from TBL_BOARD where bno in (%s)";
		
		sql = String.format(sql, Arrays.stream(checkBno).map(String::valueOf).collect(Collectors.joining(",")));		
		

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}		
		return result;
	}
}

