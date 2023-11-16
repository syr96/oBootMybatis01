package com.example.oBootMybatis01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oBootMybatis01.model.Dept;
import com.example.oBootMybatis01.model.Emp;
import com.example.oBootMybatis01.model.SampleVO;
import com.example.oBootMybatis01.service.EmpService;
import lombok.RequiredArgsConstructor;

//@Controller + @ResponseBody 를 합친게 RestController(두개 따로 써도됨 )  
//RestController는 Rest API 혹은 ajax를 쓸때 사용한다
@RestController
@RequiredArgsConstructor
public class EmpRestController {
	
	private final EmpService es;
	
	@RequestMapping("/helloText")
	public String helloText() {
		System.out.println("EmpRestController Start...");
		String hello = "안녕";
		//	StringConverter(RestController에있는 @ResponseBody에의해서 이동하고 viewResolver를 바로 타지않음)
		return hello;
	}
	//http://jsonviewer.stack.hu
	@RequestMapping("/sample/sendVO2")
	public SampleVO sendVO2(int deptno) {
		System.out.println("@RestController deptno -->" + deptno);
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(deptno);
		// 객체면 --> JsonConverter
		return vo;
	}
	
	@RequestMapping("/sendVO3")
	public List<Dept> sendVO3() {
		System.out.println("@RestController senVO3 Start...");
		List<Dept> deptList = es.deptSelect();
		return deptList;
	}
	
	@RequestMapping("/empnoDelete")
	public String empnoDelete(Emp emp) {
		System.out.println("@RestController empnoDelete START");
		System.out.println("@RestController empnoDelete emp.getEname() --> " + emp.getEname());
		int delStatus = es.deleteEmp(emp.getEmpno());
		String delStatusStr = Integer.toString(delStatus);
		return delStatusStr;
	}
}
