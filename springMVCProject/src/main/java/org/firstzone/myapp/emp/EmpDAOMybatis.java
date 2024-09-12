package org.firstzone.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOMybatis{

	@Autowired
	SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(EmpDAOMybatis.class);
	String namespace = "org.firstzone.myapp.emp.";

	public EmpDTO loginChk(String email, String phone) {
		EmpDTO emp = sqlSession.selectOne(namespace + "loginChk", email);
		logger.info(emp==null?"존재하지 않는 직원":emp.toString());
		return emp;
	}

	public int selectByEmail(String email) {
		Integer result = sqlSession.selectOne(namespace+"selectByEmail", email);
		return result;
	}

	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> mlist = sqlSession.selectList(namespace+"selectAllManager");
		return mlist;
	}

	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = sqlSession.selectList(namespace+"selectAll");
		return emplist;
	}

	public List<JobDTO> selectAllJob() {
		List<JobDTO> joblist = sqlSession.selectList(namespace+"selectAllJob");
		return joblist;
	}

	public EmpDTO selectById(int empId){
		EmpDTO emp = sqlSession.selectOne(namespace+"selectById", empId);
		return emp;
	}

	public List<EmpDTO> selectByDept(int deptid) {
		List<EmpDTO> empList = sqlSession.selectList(namespace + "selectByDeptId", deptid);
		return empList;
	}

	public List<EmpDTO> selectByJobId(String jobId) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJobid", "%"+jobId+"%");

		logger.info(emplist.toString());
		logger.info(emplist.size() + "건의 job 조회됨");

		return emplist;
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("department_id", deptid);
		conditionMap.put("job_id", jobid);
		conditionMap.put("hire_date", hdate);
		conditionMap.put("salary", salary);

		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition", conditionMap);

		logger.info(emplist.toString());
		logger.info(emplist.size() + "건 조회됨");

		return emplist;
	}

	public int empInsert(EmpDTO emp) {
		int result = sqlSession.insert(namespace + "empInsert", emp);
		return result;
	}

	public int empUpdate(EmpDTO emp) {
		int result = sqlSession.update(namespace + "empUpdate", emp);
		return result;
	}

	public int empDelete(int empid) {
		int result = sqlSession.delete(namespace + "empDelete", empid);
		return result;
	}

//	@Override
//	public Map<String, Object> empInfo(int empid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public double callFunction(int empid) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
