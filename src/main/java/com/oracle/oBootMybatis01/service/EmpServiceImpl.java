package com.oracle.oBootMybatis01.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.oBootMybatis01.dao.DeptDao;
import com.oracle.oBootMybatis01.dao.EmpDao;
import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.DeptVo;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // EmpDao(또는 DeptDao) 생성자 + autowired
public class EmpServiceImpl implements EmpService {
	private final EmpDao ed; // 어노테이션 생성자 DI방식
	private final DeptDao dd;
	
	@Override
	public int totalEmp() {
		System.out.println("EmpServiceImpl Start total...");
		int totEmpCnt = ed.totalEmp();
		System.out.println("EmpServiceImpl totalEmp totEmpCnt -> " + totEmpCnt);
		return totEmpCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		// Dao
		// ed.listEmp(emp);
		System.out.println("EmpServiceImpl listManager Start...");
		List<Emp> listEmp = ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp empList.size() -> " + listEmp.size());
		return listEmp;
	}

	@Override
	public Emp detailEmp(int empno) {
//	1. EmpService안에 detailEmp method 선언
//	   1) parameter : empno
//	   2) Return      Emp
		Emp emp = ed.detailEmp(empno);
		return emp;
	}

	@Override
	public int updateEmp(Emp emp) {
//      1. EmpService안에 updateEmp method 선언
//      1) parameter : Emp
//      2) Return      updateCount (int)
		int updateCount = ed.updateEmp(emp);
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManager Start...");
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listEmp empList.size() -> " + empList.size());
		return empList;
	}

	// dept 정보
	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpServiceImpl deptSelect Start...");
		deptList = dd.deptSelect();
		System.out.println("EmpServiceImpl deptSelect deptList.size() -> " + deptList.size());
		return deptList;
	}

	@Override
	public int insertEmp(Emp emp) {
		int insertEmp = ed.insertEmp(emp);
		return insertEmp;
	}

	@Override
	public int deleteEmp(int empno) {
		int deleteEmp = ed.deleteEmp(empno);
		return deleteEmp;
	}

	@Override
	public List<Emp> listSearchEmp(Emp emp) {
		List<Emp> empSearchList = null;
		System.out.println("EmpServiceImpl listEmp Start...");		
		empSearchList = ed.empSearchList3(emp);
		System.out.println("EmpServiceImpl listSearchEmp empSearchList.size() -> " + empSearchList.size());		
		return empSearchList;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		System.out.println("EmpServiceImpl Start total...");
		int totEmpCnt = ed.condTotalEmp(emp);
		System.out.println("EmpServiceImpl totalEmp totEmpCnt -> " + totEmpCnt);
		return totEmpCnt;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> listEmpDept = ed.listEmpDept();
		return listEmpDept;
	}

	@Override
	public void insertDept(DeptVo deptVo) {
		System.out.println("EmpServiceImpl insertDept Start...");
		dd.insertDept(deptVo);
	}

	@Override
	public void selListDept(HashMap<String, Object> map) {
		System.out.println("EmpServiceImpl selListDept Start...");
		dd.selListDept(map);
	}
	

}
