package org.firstzone.myapp.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

//DAO(Data Access占쎈릭占쎈뮉 �뜮袁⑼옙占쎈빍占쎈뮞 嚥≪뮇彛낉옙�뱽 筌ｌ꼶�봺占쎈릭占쎈뮉 Object)
@Repository
public class EmpDAO {
	//1, field�씠�슜�븯湲�
	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
/*	
	//2, �깮�꽦�옄 �씠�슜�븯湲�
	@Autowired
	public EmpDAO(DataSource ds) {
		this.ds = ds;
	}
	
	//3, setter�꽔湲�
	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
*/	
	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement�몴占� 占쎄맒占쎈꺗獄쏆룇�벉, 獄쏅뗄�뵥占쎈뎃癰귨옙占쎈땾(?)�몴占� 筌욑옙占쎌뜚
	ResultSet rs;

	// 1, 筌욊낯�뜚 筌뤴뫀紐� 鈺곌퀬�돳
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();// ArrayList筌띾Þ�� 占쎈뼄�몴占� 椰꾨챶以덌옙猷� 獄쏅뗀占쏙옙 占쎈땾 占쎌뿳占쎌몵沃섓옙嚥∽옙 emplist�몴占� List占쎌굨占쎄묶嚥∽옙 占쎈뼖占쎈툡占쎈う占쎈뼄.
		String sql = "select * from employees";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// 燁살눖�쓥占쎌뵠 11揶쏆뮆�뵬 占쎈뼄 占쎈쾺疫꿸퀣肉� 占쎄섐�눧占� 筌띾‘�벉
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}

		return emplist;
	}

	// 筌띲끇�빍占쏙옙 占쎌읈筌ｏ옙 鈺곌퀬�돳
	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> emplist = new ArrayList<>();// ArrayList筌띾Þ�� 占쎈뼄�몴占� 椰꾨챶以덌옙猷� 獄쏅뗀占쏙옙 占쎈땾 占쎌뿳占쎌몵沃섓옙嚥∽옙 emplist�몴占� List占쎌굨占쎄묶嚥∽옙 占쎈뼖占쎈툡占쎈う占쎈뼄.
		String sql = "select employee_id, first_name ||'  '|| last_name fullname\r\n" + "from employees\r\n"
				+ "where employee_id in (\r\n" + "                            select distinct manager_id\r\n"
				+ "                            from employees\r\n"
				+ "                            where manager_id is not null )\r\n";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// 燁살눖�쓥占쎌뵠 11揶쏆뮆�뵬 占쎈뼄 占쎈쾺疫꿸퀣肉� 占쎄섐�눧占� 筌띾‘�벉
				HashMap<String, Object> data = new HashMap<>();// 筌띿꼷肉� 占쎈툧占쎈굶筌롳옙 占쎈뼄占쎈뻻 DTO嚥∽옙 獄쏅떽�벊占쎈즲 占쎈쭆占쎈뼄占쎈릭占쎈뼎
				data.put("employee_id", rs.getInt(1));
				data.put("fullname", rs.getString(2));
				emplist.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return emplist;
	}

	// 筌뤴뫀諭� 筌욊낯毓� 鈺곌퀬�돳
	public List<JobDTO> selectAllJob() {
		List<JobDTO> joblist = new ArrayList<>();// ArrayList筌띾Þ�� 占쎈뼄�몴占� 椰꾨챶以덌옙猷� 獄쏅뗀占쏙옙 占쎈땾 占쎌뿳占쎌몵沃섓옙嚥∽옙 emplist�몴占� List占쎌굨占쎄묶嚥∽옙 占쎈뼖占쎈툡占쎈う占쎈뼄.
		String sql = "select * from jobs";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				JobDTO job = new JobDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				joblist.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return joblist;
	}

	
	public EmpDTO loginChk(String email, String phone) {
		EmpDTO emp = null;
		String sql = "Select * from employees where email = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getString("phone_number").equals(phone)) {
					emp = new EmpDTO();
					emp.setEmployee_id(rs.getInt("employee_id"));
					emp.setFirst_name(rs.getString("first_name"));
				} else {
					emp = new EmpDTO();
					emp.setEmployee_id(-2);
				}
			} else {
				emp = new EmpDTO();
				emp.setEmployee_id(-1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emp;
	}



	// 2, 占쎈뱟筌욑옙 筌욊낯�뜚占쎌벥 占쎄맒占쎄쉭癰귣떯由�
	public EmpDTO selectByID(int empid) {
		EmpDTO emp = null;
		String sql = "Select * from employees where employee_id = " + empid;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return emp;
	}

	public int selectByEmail(String email) {
		String sql = "Select 1 from employees where email = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return 0;
	}

	// 3, 占쎈뱟筌욑옙 �겫占쏙옙苑뚳옙�벥 占쎄맒占쎄쉭癰귣떯由�
	public List<EmpDTO> selectBydept(int deptid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();// ArrayList筌띾Þ�� 占쎈뼄�몴占� 椰꾨챶以덌옙猷� 獄쏅뗀占쏙옙 占쎈땾 占쎌뿳占쎌몵沃섓옙嚥∽옙 emplist�몴占� List占쎌굨占쎄묶嚥∽옙 占쎈뼖占쎈툡占쎈う占쎈뼄.
		// String sql = "select * from employees where department_id = " + deptid; //占쎄돌餓λ쵐肉�
		// 占쎌뜎占쎈떊占쎈막 4甕곤옙 �눧紐꾩젫筌ｌ꼶�쓥 �뜮袁れ뒞占쎌몛占쎌읅占쎌몵嚥∽옙 占쎄쉭占쎈샒占쎈퉸占쎈튊占쎈막 占쎈땾 占쎌뿳占쎈뼄.
		String sql = "select * from employees where department_id = ?";// 獄쏅뗄�뵥占쎈뎃癰귨옙占쎈땾 '?'�몴占� 占쎈꽰占쎈퉸 占쎄쉭占쎈샒占쎌뱽 占쎈젶占쎈릭野껓옙 占쎈맙
		try {
			conn = ds.getConnection();
			// st = conn.createStatement();
			// rs = st.executeQuery(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);// 1甕곕뜆�럮 ? 占쎈퓠 deptid�몴占� 占쎄퐫疫뀐옙
			rs = pst.executeQuery();
			while (rs.next()) {
				// 燁살눖�쓥占쎌뵠 11揶쏆뮆�뵬 占쎈뼄 占쎈쾺疫꿸퀣肉� 占쎄섐�눧占� 筌띾‘�벉
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return emplist;
	}

	// 4, 占쎈뼄占쎈펶占쎈립 鈺곌퀗援뷂옙�몵嚥∽옙 鈺곌퀬�돳占쎈릭疫뀐옙
	// �겫占쏙옙苑뚩퉪占�(=), 筌욊낯肄됭퉪占�(=), 占쎌뿯占쎄텢占쎌뵬癰귨옙(占쎈섧占쎌젫 占쎌뵠占쎌뜎占쎈퓠 占쎌뿯占쎄텢占쎈뻥占쎄돌, >=), 疫뀀맩肉ц퉪占�(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();// ArrayList筌띾Þ�� 占쎈뼄�몴占� 椰꾨챶以덌옙猷� 獄쏅뗀占쏙옙 占쎈땾 占쎌뿳占쎌몵沃섓옙嚥∽옙 emplist�몴占� List占쎌굨占쎄묶嚥∽옙 占쎈뼖占쎈툡占쎈う占쎈뼄.
		// String sql = "select * from employees where department_id = " + deptid; //占쎄돌餓λ쵐肉�
		// 占쎌뜎占쎈떊占쎈막 4甕곤옙 �눧紐꾩젫筌ｌ꼶�쓥 �뜮袁れ뒞占쎌몛占쎌읅占쎌몵嚥∽옙 占쎄쉭占쎈샒占쎈퉸占쎈튊占쎈막 占쎈땾 占쎌뿳占쎈뼄.
		String sql = "select * " + " from employees " + " where department_id = ?" + " and job_id = ?"
				+ " and hire_date >= ? " + " and salary >= ? ";// 獄쏅뗄�뵥占쎈뎃癰귨옙占쎈땾 '?'�몴占� 占쎈꽰占쎈퉸 占쎄쉭占쎈샒占쎌뱽 占쎈젶占쎈릭野껓옙 占쎈맙
		try {
			conn = ds.getConnection();
			// st = conn.createStatement();
			// rs = st.executeQuery(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);// 1甕곕뜆�럮 ? 占쎈퓠 deptid�몴占� 占쎄퐫疫뀐옙
			pst.setString(2, jobid);// 2甕곕뜆�럮 ? 占쎈퓠 jobid�몴占� 占쎄퐫疫뀐옙
			pst.setDate(3, hdate);// 3甕곕뜆�럮 ? 占쎈퓠 hdate�몴占� 占쎄퐫疫뀐옙
			pst.setInt(4, salary);// 4甕곕뜆�럮 ? 占쎈퓠 salary�몴占� 占쎄퐫疫뀐옙
			rs = pst.executeQuery();
			while (rs.next()) {
				// 燁살눖�쓥占쎌뵠 11揶쏆뮆�뵬 占쎈뼄 占쎈쾺疫꿸퀣肉� 占쎄섐�눧占� 筌띾‘�벉
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);// 占쎈퉸占쎌젫
		}
		return emplist;
	}

	// 5, 占쎌뿯占쎌젾(Insert)
	public int empInsert(EmpDTO emp) {
		int result = 0; // insert 占쎈뼄占쎈솭 占쎈뻻 -1, insert占쎈막野껓옙 占쎈씨占쎌뱽 占쎈뻻 0
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,? )";
		try {
			conn = ds.getConnection();// setAutoCommit(true)占쎈┷占쎈선占쎌뿳占쎌벉
			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();// DML�눧紐꾩삢占쏙옙 excuteUpdate, select�눧紐꾬옙 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 6. 占쎈땾占쎌젟(Update)
	public int empUpdate(EmpDTO emp) {
		int result = 0; // insert 占쎈뼄占쎈솭 占쎈뻻 -1, insert占쎈막野껓옙 占쎈씨占쎌뱽 占쎈뻻 0
		String sql = "update employees " + " set" + " FIRST_NAME = ?, " + " LAST_NAME = ?, " + " EMAIL = ?, "
				+ " PHONE_NUMBER = ?, " + " HIRE_DATE = ?, " + " JOB_ID = ?, " + " SALARY = ?, "
				+ " COMMISSION_PCT = ?, " + " MANAGER_ID = ?, " + " DEPARTMENT_ID = ? " + " where EMPLOYEE_ID = ?";
		try {
			conn = ds.getConnection();// setAutoCommit(true)占쎈┷占쎈선占쎌뿳占쎌벉
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			pst.setInt(11, emp.getEmployee_id());
			result = pst.executeUpdate();// DML�눧紐꾩삢占쏙옙 excuteUpdate, select�눧紐꾬옙 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 7, 占쎄텣占쎌젫(Delete)
	public int empDelete(int empid) {
		int result = 0; // insert 占쎈뼄占쎈솭 占쎈뻻 -1, insert占쎈막野껓옙 占쎈씨占쎌뱽 占쎈뻻 0
		String sql = "delete from employees where EMPLOYEE_ID = ? ";
		try {
			conn = ds.getConnection();// setAutoCommit(true)占쎈┷占쎈선占쎌뿳占쎌벉
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			result = pst.executeUpdate();// DML�눧紐꾩삢占쏙옙 excuteUpdate, select�눧紐꾬옙 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 燁살눖�쓥 占쎈릭占쎄돌�몴占� �빊遺욱뀱
	private EmpDTO makeEmp(ResultSet rs) {
		// TODO Auto-generated method stub
		EmpDTO emp = new EmpDTO();
		try {
			emp.setCommission_pct(rs.getDouble("commission_pct"));// 占쎈뼄占쎌젫嚥≪뮆�뮉 燁살눖�쓥占쎌벥 甕곕뜇�깈�몴占� 占쎈르 占쎈땾 占쎈씨占쎌몵沃섓옙嚥∽옙 占쎌뵠占쎌쟽野껓옙 占쎈퉸餓ο옙占쎈뼄.
			emp.setDepartment_id(rs.getInt("department_id"));
			emp.setEmail(rs.getString("email"));
			emp.setEmployee_id(rs.getInt("employee_id"));
			emp.setFirst_name(rs.getString("first_name"));
			emp.setJob_id(rs.getString("job_id"));
			emp.setLast_name(rs.getString("last_name"));
			emp.setManager_id(rs.getInt("manager_id"));
			emp.setHire_date(rs.getDate("hire_date"));
			emp.setPhone_number(rs.getString("phone_number"));
			emp.setSalary(rs.getInt("salary"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	// 筌욊낯�뜚甕곕뜇�깈�몴占� 占쎌뿯占쎌젾獄쏆룇釉섓옙苑� 筌욊낯�뜚占쎌젟癰귨옙(占쎌뵠�뵳占�, 燁살늿肄�, 疫뀀맩肉�)�몴占� return
	public Map<String, Object> empInfo(int empid) {
		// TODO Auto-generated method stub
		Map<String, Object> empMap = new HashMap<>();
		String fname = null;
		String job = null;
		int salary = 0;
		String sql = "{call sp_empInfo(?, ?, ?, ?)";
		CallableStatement cstmt = null;
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			boolean result = cstmt.execute();
			fname = cstmt.getString(2);
			job = cstmt.getString(3);
			salary = cstmt.getInt(4);
			empMap.put("fname", fname);
			empMap.put("job", job);
			empMap.put("salary", salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		return empMap;
	}

	// 筌욊낯�뜚 甕곕뜇�깈揶쏉옙 占쎈굶占쎈선占쎌궎筌롳옙 筌욊낯�뜚癰귣�瑗ワ옙�뮞�몴占� return 占쎈릭占쎈뮉 占쎈맙占쎈땾�몴占� 占쎌깈�빊�뮉釉놂옙�뼄.
	public double callFunction(int empid) {
		double bonus = 0;

		String sql = "select f_bonus(?) from dual";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if (rs.next()) {
				bonus = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bonus;
	}

	// 占쎈뱟占쎌젟�겫占쏙옙苑뚳옙肉� 域뱀눖龜占쎈릭占쎈뮉 筌욊낯�뜚占쎈굶

	// 占쎌뿯占쎌젾
	// 占쎈땾占쎌젟
	// 占쎄텣占쎌젫
}
