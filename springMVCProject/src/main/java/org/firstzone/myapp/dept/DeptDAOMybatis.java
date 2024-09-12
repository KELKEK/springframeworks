package org.firstzone.myapp.dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO(Data Access�븯�뒗 鍮꾩��땲�뒪濡쒖쭅�쓣 �옉�꽦�븯�뒗 Object)
@Repository("deptmybatis")
public class DeptDAOMybatis implements DeptDAOInterface {
	// 타입이 같으면 Injection
	// 같은 타입이 여러 개이면 오류(Error)
	@Autowired
	SqlSession sqlSession;
	
	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String namespace = "com.shinhan.dept.";
	public List<DeptDTO> selectAll(){
		System.out.println("=====");
		logger.info("DeptDAOMybatis....session");
		return sqlSession.selectList(namespace + "selectAll");
	}
	// 8. �궘�젣(Delete)
	public int deptDelete(int deptid) {
		logger.info("deptmybatis...deptDelete");
		return sqlSession.delete(namespace+"deptDelete", deptid);
	}
	

	// 7. �닔�젙(Update)
	public int deptUpdate(DeptDTO dept) {
		logger.info("deptmybatis...deptUpdate");
		return sqlSession.update(namespace+"deptUpdate", dept);
	}

	// 6. �엯�젰(Insert)
	public int deptInsert(DeptDTO dept) {
		logger.info("deptmybatis...deptInsert");
		return sqlSession.insert(namespace+"deptInsert", dept);
	}

	// 5. �떎�뼇�븳 議곌굔�쑝濡� 議고쉶�븯湲�
	// 遺��꽌蹂�(=), 吏곸콉蹂�(=), �엯�궗�씪蹂�(>=), 湲됱뿬(>=)
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {

		return null;
	}

	// 2. �듅�젙遺��꽌�쓽 �긽�꽭蹂닿린
	public DeptDTO selectById(int deptid) {
		logger.info("DeptDaomybatis...selectbyid");
		return sqlSession.selectOne(namespace+"selectById", deptid);
	}
	
	public DeptDTO selectByName(String deptname) {
		return sqlSession.selectOne(namespace+"selectByName", deptname);
	}

//	// 1. 遺��꽌紐⑤몢議고쉶
//	public List<DeptDTO> selectAll() {
//
//		return null;
//	}

	// �듅�젙吏곸썝 1紐� 議고쉶
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		return null;
	}
}
