package com.example.oBootMybatis01.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.oBootMybatis01.model.Emp;
import com.example.oBootMybatis01.model.EmpDept;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class EmpDaoImpl implements EmpDao {
	// Mybatis DB 연동
	private final SqlSession session;
	
	@Override
	public int totalEmp() {
		int totEmpCount = 0;
		System.out.println("EmpDaoImp1 Start total...");
		
		// 문법적인 오류는 없지만 쿼리동작 부분에는 try catch 걸어야함(에러가 자주 나오는곳이라?)
		try {											 
			//	totEmpCount = session.selectOne("com.example.oBootMybatis01.EmpMapper.empTotal"); 도 가능 Mapper의 Emp.xml의 namespace에 의해서
			totEmpCount = session.selectOne("empTotal");
			System.out.println("EmpDaoImpl totalEmp totEmpCount -->" + totEmpCount);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalEmp Exception -->" + e.getMessage());
		} 
		
		return totEmpCount;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		try {				
			// empList = session.selectList로 생각 
			//					     		Map ID	    parameter
			empList = session.selectList("tkEmpListAll",emp);
			
			// empList.size()가 10인 이유 tkEmpListAll에서 WHERE rn >= #{start}  AND rn <= #{end} 에 의해 10개씩 들고옴
			System.out.println("EmpDaoImpl listEmp empList.size() --> " + empList.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImp1 List<Emp> Exception -->" + e.getMessage());
		}
		return empList;
	}

	@Override
	public Emp detailEmp(int empno) {
		System.out.println("EmpDaoImpl detail start..");
		Emp emp = null;
		try {
			emp = session.selectOne("tkEmpSelOne", empno);
			System.out.println("EmpDaoImpl detail getEname ->" + emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImp1 detailEmp Exception --> " + e.getMessage());
		}
		return emp;
	}

	@Override
	public int updateEmp(Emp emp) {
		System.out.println("EmpDaoimpl updateEmp start..");
		int updateCount = 0;
		try {
			updateCount = session.update("tkEmpUpdate",emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImp1 updateEmp Exception --> " + e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listManager Start...");
		try {
			// emp 관리자만 Select				Naming Rule
			empList = session.selectList("tkSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listManager Exception -->" + e.getMessage());
		}
		return empList;
	}

	@Override
	public int insertEmp(Emp emp) {
		System.out.println("EmpDaoImpl insertEmp start...");
		int result = 0;
		try {
			result = session.insert("insertEmp", emp);
			// result = session.insert("deptEmp",dept); 위아래 2개 다 한다고 가정(둘다 넣어야 되는경우) 커밋단위 - 세션단위로 커밋됨
			//											즉 위는 되고 아래는 안되는경우가생기고 이게 무결성을 깨뜨릴 수 있음
		} catch (Exception e) {
			System.out.println("EmpDaoImpl insertEmp Exception --> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteEmp(int empno) {
		System.out.println("EmpDaoImpl deleteEmp start...");
		int result = 0;
		System.out.println("EmpDaoImpl delete empno -->" + empno);
		try {
			result = session.delete("deleteEmp", empno);
			System.out.println("EmpDaoImpl delete result -->" + result);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl deleteEmp Exception --> " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Emp> empSearchList3(Emp emp) {
		List<Emp> empSearchList3 = null;
		System.out.println("EmpDaoImpl empSearchList3 start...");
		try {
			// keyword 검색
			// Naming Rule							Map Id			parameter
			empSearchList3 = session.selectList("tkEmpSearchList3", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception -->" + e.getMessage());
		}
		return empSearchList3;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		int totEmpCount = 0;
		System.out.println("EmpDaoImp1  condTotalEmp Start total...");
		
		try {											 
			//	totEmpCount = session.selectOne("com.example.oBootMybatis01.EmpMapper.empTotal"); 도 가능 Mapper의 Emp.xml의 namespace에 의해서
			totEmpCount = session.selectOne("condEmpTotal", emp);
			System.out.println("EmpDaoImp1 condEmpTotal -->" + totEmpCount);
		} catch (Exception e) {
			System.out.println("EmpDaoImp1 condEmpTotal condException -->" + e.getMessage());
		}
		
		return totEmpCount;
	}


	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpDaoImpl  listEmpDept Start total...");
		List<EmpDept> listEmpDept = null;
		try {
			listEmpDept = session.selectList("tkListEmpDept");
			System.out.println("EmpDaoImpl listEmpDept empDept.size() --> " +listEmpDept.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmpDept empDept Exception --> " +e.getMessage());
		}
		return listEmpDept;
	}

	@Override
	public String deptName(int deptno) {
		System.out.println("EmpDaoImpl deptName Start..");
		String resultStr ="";
		
		try {
			System.out.println("EmpDaoImpl deptName deptno-->" + deptno);
			resultStr = session.selectOne("tkDeptName",deptno);
			System.out.println("EmpDaoImpl deptName resultStr -->" + resultStr);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl deptName Exception -->" + e.getMessage());
		}
		return resultStr;
	}
}
