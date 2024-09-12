package org.firstzone.myapp.dept;

import java.util.List;

public interface DeptDAOInterface {
	public List<DeptDTO> selectAll();
	public DeptDTO selectById(int deptid);
	public DeptDTO selectByName(String deptname);
	public int deptDelete(int deptid);
	public int deptUpdate(DeptDTO dept);
	public int deptInsert(DeptDTO dept);
}
