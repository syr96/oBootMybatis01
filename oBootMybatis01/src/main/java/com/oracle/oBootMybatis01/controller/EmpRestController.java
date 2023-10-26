package com.oracle.oBootMybatis01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController	// @Controller + @ResponseBody
@RequiredArgsConstructor
public class EmpRestController {
	private final EmpService es;
	
	
	
	@RequestMapping("/sendV03")
	public List<Dept> sendV03() {
		System.out.println("@RestController sendV03 START");
		List<Dept> deptList = es.deptSelect();
		return deptList;
	}
	
	@RequestMapping("/empnoDelete")
	public String empnoDelete(Emp emp) {
		System.out.println("@RestController empnoDelete START");
		System.out.println("@RestController empnoDelete emp.getEname() -> " + emp.getEname());
		int delStatus = es.deleteEmp(emp.getEmpno());
		String delStatusStr = Integer.toString(delStatus);
		return delStatusStr;
	}
}
