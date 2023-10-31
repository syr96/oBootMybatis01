package com.oracle.oBootMybatis01.service;

import java.util.HashMap;
import java.util.List;

import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.DeptVo;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;

public interface EmpService {
	int 			totalEmp();
	List<Emp> 		listEmp(Emp emp);
	Emp 			detailEmp(int empno);
	int 			updateEmp(Emp emp);
	List<Emp> 		listManager();
	List<Dept> 		deptSelect();
	int 			insertEmp(Emp emp);
	int 			deleteEmp(int empno);
	List<Emp> 		listSearchEmp(Emp emp);
	int 			condTotalEmp(Emp emp);
	List<EmpDept>	listEmpDept();
	void 			insertDept(DeptVo deptVo);
	void 			selListDept(HashMap<String, Object> map);
}
