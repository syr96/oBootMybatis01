package com.oracle.oBootMybatis01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpDaoImpl implements EmpDao {
	// Mybatis DB 연동
	private final SqlSession session;
	
	@Override
	public int totalEmp() {
		int totEmpCount = 0;
		System.out.println("EmpDaoImpl Start total...");
		
		try { // session이 안잡힐 수 있기 때문에 try-catch를 해준다
			totEmpCount = session.selectOne("empTotal"); // Emp.xml에서 id="empTotal"를 가져온다
			System.out.println("EmpDaoImpl totalEmp totEmpCount -> " + totEmpCount);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalEmp Exception -> " + e.getMessage());
		}
		return totEmpCount;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> listEmp = null;
		System.out.println("EmpDaoImpl listEmp Start...");
		try {
			listEmp = session.selectList("tkEmpListAll", emp);
			System.out.println("EmpDaoImpl listEmp empList.size() -> " + listEmp.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp e.getMessage() -> " + e.getMessage());			
		}
		return listEmp;
	}

	@Override
	public Emp detailEmp(int empno) {
//		2. EmpDao   detailEmp method 선언 
//								 mapper ID   ,    Parameter
//		emp = session.selectOne("tkEmpSelOne",    empno);
		Emp emp = null;
		try {
			emp = session.selectOne("tkEmpSelOne", empno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}

	@Override
	public int updateEmp(Emp emp) {
//   	2. EmpDao updateEmp method 선언
//							   		 mapper ID	  , Parameter
//		updateCount = session.update("tkEmpUpdate", emp);
		int updateCount = 0;
		try {
			updateCount = session.update("tkEmpUpdate", emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listManager Start...");
		try {
			// emp 관리자만 Select			  Naming Rule
			empList = session.selectList("tkSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listManager Exception -> " + e.getMessage());
		}
		return empList;
	}

	@Override
	public int insertEmp(Emp emp) {
		int insertEmp = 0;
		try {
			insertEmp = session.insert("tkEmpInsert", emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return insertEmp;
	}

	@Override
	public int deleteEmp(int empno) {
		int deleteEmp = 0;
		try {
			deleteEmp = session.delete("tkEmpDelete", empno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return deleteEmp;
	}

	@Override
	public List<Emp> empSearchList3(Emp emp) {
		List<Emp> empSearchList3 = null;
		System.out.println("EmpDaoImpl empSearchList3 Start...");
		try {
			// keyword검색
			// Naming Rule							Map ID			parameter
			empSearchList3 = session.selectList("tkEmpSearchList3", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception -> " + e.getMessage());
		}
		return empSearchList3;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		int totEmpCount = 0;
		System.out.println("EmpDaoImpl Start total...");
		
		try { // session이 안잡힐 수 있기 때문에 try-catch를 해준다
			totEmpCount = session.selectOne("condEmpTotal", emp); // Emp.xml에서 id="empTotal"를 가져온다
			System.out.println("EmpDaoImpl totalEmp totEmpCount -> " + totEmpCount);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalEmp Exception -> " + e.getMessage());
		}
		return totEmpCount;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> listEmpDept = null;
		try {
			listEmpDept = session.selectList("tkListEmpDept");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listEmpDept;
	}

}

