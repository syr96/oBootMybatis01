package com.example.oBootMybatis01.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.oBootMybatis01.dao.DeptDao;
import com.example.oBootMybatis01.dao.EmpDao;
import com.example.oBootMybatis01.dao.Member1Dao;
import com.example.oBootMybatis01.model.Dept;
import com.example.oBootMybatis01.model.DeptVO;
import com.example.oBootMybatis01.model.Emp;
import com.example.oBootMybatis01.model.EmpDept;
import com.example.oBootMybatis01.model.Member1;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	private final EmpDao ed;
	private final DeptDao dd;
	private final Member1Dao md;
	
	@Override
	public int totalEmp() {
			System.out.println("EmpServiceImpl Start total...");
			int totEmpCnt = ed.totalEmp();
			System.out.println("EmpServiceImpl totalEmp totalEmpCnt --> " + totEmpCnt);
		return totEmpCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		// Service
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManger Start... ");
		empList =ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp empList.size() -->" + empList.size());
		return empList;
	}

	@Override
	public Emp detailEmp(int empno) {
		System.out.println("EmpServiceImpl detailEmp Start...");
		Emp emp = ed.detailEmp(empno);
		return emp;
	}

	@Override
	public int updateEmp(Emp emp) {
		System.out.println("EmpServiceImpl updateEmp Start...");
		int updateCount = ed.updateEmp(emp);
		System.out.println("EmpServiceImpl updateEmp result --> " + updateCount);
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManager Start...");
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listEmp empList.size() -->" + empList.size());
		return empList;
	}

	// dept 정보
	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpServiceImpl deptSelect start...");
		deptList = dd.deptSelect();
		System.out.println("EmpServiceImpl deptSelect deptList.size() --> " + deptList.size());
		return deptList;
	}

	@Override
	public int insertEmp(Emp emp) {
		
		System.out.println("EmpServiceImpl insertEmp start...");
		int result = ed.insertEmp(emp);
		System.out.println("EmpServiceImpl insertEmp result -->" + result);
		return result;
	}

	@Override
	public int deleteEmp(int empno) {
		System.out.println("EmpServiceImpl deleteEmp start...");
		int result = ed.deleteEmp(empno);
		
		return result;
	}

	@Override
	public List<Emp> listSearchEmp(Emp emp) {
		List<Emp> empSearchList = null;
		System.out.println("EmpServiceImpl listSearchEmp start...");
		empSearchList = ed.empSearchList3(emp);
		System.out.println("EmpServiceImpl listSearch empSearchList.size()" + empSearchList.size());
		return empSearchList;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		System.out.println("EmpServiceImpl condTotalEmp Start ...");
		int totEmpCnt = ed.condTotalEmp(emp);
		System.out.println("EmpServiceImpl condTotalEmp totalEmpCnt --> " + totEmpCnt);
		return totEmpCnt;
		
	}

	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpServiceImpl listEmpDept Start...");
		List<EmpDept> listEmpDept = ed.listEmpDept();
		System.out.println("EmpServiceImpl listEmpDept.size() -->" + listEmpDept.size());
		return listEmpDept;
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("EmpServiceImpl insertDept Start...");
		dd.insertDept(deptVO);
		
	}

	@Override
	public void selListDept(HashMap<String, Object> map) {
		System.out.println("EmpServiceImpl selListDept Start...");
		dd.selListDept(map);
		
	}

	@Override
	public int memCount(String id) {
		System.out.println("EmpServiceImpl memCount start...");
		
		return md.memCount(id);
	}

	@Override
	public List<Member1> listMem(Member1 member1) {
		System.out.println("EmpServiceImpl listMem start...");
		return md.listMem(member1);
	}

	@Override
	public String deptName(int deptno) {
		System.out.println("EmpServiceImpl deptName Start...");
		return ed.deptName(deptno);
	}

	@Override
	public int transactionInsertUpdate() {
		System.out.println("EmpServiceImpltransactionInsertUpdate Start... ");
//		return md.transactionInsertUpdate();  // transaction X
		return md.transactionInsertUpdate3(); // transaction O
	}


	
	
}
