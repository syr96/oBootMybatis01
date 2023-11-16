package com.example.oBootMybatis01.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.oBootMybatis01.model.Dept;
import com.example.oBootMybatis01.model.DeptVO;
import com.example.oBootMybatis01.model.Emp;
import com.example.oBootMybatis01.model.EmpDept;
import com.example.oBootMybatis01.model.Member1;

@Service
public interface EmpService {
	int		  		totalEmp();
	List<Emp> 		listEmp(Emp emp);
	Emp 			detailEmp(int empno);
	int 			updateEmp(Emp emp);
	List<Emp> 		listManager();
	List<Dept>		deptSelect();
	int 			insertEmp(Emp emp);
	int 			deleteEmp(int empno);
	List<Emp> 		listSearchEmp(Emp emp);
	int 			condTotalEmp(Emp emp);
	List<EmpDept> 	listEmpDept();
	void 			insertDept(DeptVO deptVO);
	void 			selListDept(HashMap<String, Object> map);
	int 			memCount(String id);
	List<Member1> 	listMem(Member1 member1);
	String 			deptName(int deptno);
	int 			transactionInsertUpdate();
}
