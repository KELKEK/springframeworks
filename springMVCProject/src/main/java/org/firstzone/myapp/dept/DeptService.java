package org.firstzone.myapp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//Controller->Service->DAO
//			<-		 <-
//Service : 鍮꾩��땲�뒪 濡쒖쭅�쓣 �닔�뻾�븳�떎. (DB�� 愿��젴�뾾�뒗 濡쒖쭅 �엳�쓣�븣 �쑀�슜)
@Service
public class DeptService {
	
	@Autowired
	@Qualifier("deptmybatis")
	DeptDAOInterface deptDAO;

	// �씠由� �떖�씪�룄 �릺�뒗�뜲, 媛숈쑝硫� �븣�븘蹂닿린 �돺�떎.
	

	//8. �궘�젣(Delete)
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);

	}

	// 7. �닔�젙(Update)
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	// 6. �엯�젰(Insert)
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}

//	// 5. �떎�뼇�븳 議곌굔�쑝濡� 議고쉶�븯湲�
//	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
//		return deptDAO.selectByCondition(deptid, deptname, mid, lid);
//	}

//	// 4. �듅�젙JOB�씤 吏곸썝議고쉶
//	public List<DeptDTO> selectByJob(String jobid) {
//		return empDAO.selectByJob(jobid);
//	}
//
//	// 3. �듅�젙吏곸썝�쓽 吏곸썝議고쉶
//	public List<DeptDTO> selectByDept(int deptid) {
//		return empDAO.selectByDept(deptid);
//	}

	// 2. �듅�젙遺��꽌�쓽 �긽�꽭蹂닿린
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}

	// 1. 吏곸썝紐⑤몢議고쉶
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
}
