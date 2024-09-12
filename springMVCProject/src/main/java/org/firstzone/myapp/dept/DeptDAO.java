package org.firstzone.myapp.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

//DAO(Data Access�븯�뒗 鍮꾩��땲�뒪濡쒖쭅�쓣 �옉�꽦�븯�뒗 Object)
@Repository
public class DeptDAO implements DeptDAOInterface {
	//타입이 같으면 Injection
	//같은 타입이 여러 개이면 오류(Error)
	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	Connection conn;
	Statement st;
	PreparedStatement pst; //Statement瑜� �긽�냽諛쏆쓬, 諛붿씤�뵫蹂��닔 吏��썝
	ResultSet rs;
	
	
	//8. �궘�젣(Delete)
		public int deptDelete(int deptid) {
			int result = 0;
			String sql = "delete from departments"
					+ " where DEPARTMENT_ID=?";
			try {
				conn = ds.getConnection();
				pst = conn.prepareStatement(sql);
				pst.setInt(1, deptid);
				result = pst.executeUpdate(); //DML臾몄옣�� executeUpdate, Select臾몄� executeQuery //嫄댁닔, 紐삵븯硫� 0, �뿉�윭�굹硫� -1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}
		
	
	//7. �닔�젙(Update)
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		String sql = "update departments"
				+ " set DEPARTMENT_NAME=?,"
				+ " MANAGER_ID=?,"
				+ " LOCATION_ID=?"
				+ " where DEPARTMENT_ID=?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dept.getDepartment_name());
			pst.setInt(2, dept.getManager_id());
			pst.setInt(3, dept.getLocation_id());
			pst.setInt(4, dept.getDepartment_id());
			result = pst.executeUpdate(); //DML臾몄옣�� executeUpdate, Select臾몄� executeQuery //嫄댁닔, 紐삵븯硫� 0, �뿉�윭�굹硫� -1
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//6. �엯�젰(Insert)
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		String sql = "insert into departments values(?,?,?,?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate(); //DML臾몄옣�� executeUpdate, Select臾몄� executeQuery //嫄댁닔, 紐삵븯硫� 0, �뿉�윭�굹硫� -1
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//5. �떎�뼇�븳 議곌굔�쑝濡� 議고쉶�븯湲�
	//遺��꽌蹂�(=), 吏곸콉蹂�(=), �엯�궗�씪蹂�(>=), 湲됱뿬(>=)
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * "
				+ " from departments "
				+ " where DEPARTMENT_ID= ?"
				+ " and DEPARTMENT_NAME = ?"
				+ " and MANAGER_ID = ?"
				+ " and LOCATION_ID = ?";
		
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, deptname);
			pst.setInt(3, mid);
			pst.setInt(4, lid);
			rs = pst.executeQuery(); //sql�꽔�쑝硫� �븞�맖
			
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			DBUtil.dbDisconnect(conn, pst, rs); //�옄�떇-遺�紐⑤땲源� pst媛��뒫
		}
		return deptlist;
	}
	
	
	//2. �듅�젙遺��꽌�쓽 �긽�꽭蹂닿린
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		String sql = "select * from departments where department_id = " + deptid;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
	
	//1. 遺��꽌紐⑤몢議고쉶
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return deptlist;
	}
	
	
	//�듅�젙吏곸썝 1紐� 議고쉶
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();
		//珥� 4媛�
		dept.setDepartment_id(rs.getInt("department_id"));
		dept.setDepartment_name(rs.getString("department_name"));
		dept.setLocation_id(rs.getInt("location_id"));
		dept.setManager_id(rs.getInt("manager_id"));
		
		return dept;
	}


	@Override
	public DeptDTO selectByName(String deptname) {
		// TODO Auto-generated method stub
		return null;
	}
}
