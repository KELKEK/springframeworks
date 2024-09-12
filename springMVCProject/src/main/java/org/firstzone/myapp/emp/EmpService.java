package org.firstzone.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller -> Service ->DAO
//           <-         <-
@Service 
public class EmpService {
	

	@Autowired
	EmpDAOMybatis empDAO; //나중에 복습할 때 EmpDAOMybatis타입으로 바꾸기

	// 1. 筌욊낯�뜚 筌뤴뫀紐� 鈺곌퀬�돳
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = empDAO.selectAll();
		return emplist;
		// return empDAO.selectAll();嚥∽옙 餓κ쑴肉э옙猷� 占쎈쭆占쎈뼄.
	}
	
	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}
	
	//筌띲끇�빍占쏙옙 筌뤴뫀紐�鈺곌퀬�돳
	public List<HashMap<String, Object>> selectAllManager(){
		return empDAO.selectAllManager();
	}
	
	public List<JobDTO> selectAllJob(){
		return empDAO.selectAllJob();
	}

	// 2, 占쎈뱟占쎌젟 筌욊낯�뜚占쎌벥 占쎄맒占쎄쉭癰귣떯由�
	public EmpDTO selectByID(int empid) {
		return empDAO.selectById(empid);
	}
	
	public List<EmpDTO> selectByJob(String jobId){
		return empDAO.selectByJobId(jobId);
	}
	
	//占쎌뵠筌롫뗄�뵬 餓λ쵎�궗筌ｋ똾寃�
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}

	// 3, 占쎈뱟占쎌젟 �겫占쏙옙苑뚳옙�벥 筌욊낯�뜚鈺곌퀬�뿳
	public List<EmpDTO> selectByDept(int department_id) {
		return empDAO.selectByDept(department_id);
	}

	// 4, 占쎈뼄占쎈펶占쎈립 鈺곌퀗援뷂옙�몵嚥∽옙 鈺곌퀬�돳占쎈릭疫뀐옙
	// �겫占쏙옙苑뚩퉪占�(=), 筌욊낯肄됭퉪占�(=), 占쎌뿯占쎄텢占쎌뵬癰귨옙(占쎈섧占쎌젫 占쎌뵠占쎌뜎占쎈퓠 占쎌뿯占쎄텢占쎈뻥占쎄돌, >=), 疫뀀맩肉ц퉪占�(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 5, 占쎌뿯占쎌젾(Insert)
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 6. 占쎈땾占쎌젟(Update)
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	//7, 占쎄텣占쎌젫(Delete)
		public int empDelete(int empid) {
			return empDAO.empDelete(empid);
		}
//		//筌욊낯�뜚甕곕뜇�깈�몴占� 占쎌뵠占쎌뒠占쎈퉸占쎄퐣 筌욊낯�뜚占쎌벥 占쎌뵠�뵳袁㏓궢 筌욊낯肄됪�⑨옙 疫뀀맩肉х몴占� 鈺곌퀬�돳占쎈립占쎈뼄.
//		public Map<String, Object> empInfo(int empid) {
//			// TODO Auto-generated method stub
//			return empDAO.empInfo(empid);
//		}
//		
//		
//		public double callFunction(int empid) {
//			return empDAO.callFunction(empid);
//		}
}
