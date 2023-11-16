package com.example.oBootMybatis01.dao;

import java.util.HashMap;
import java.util.List;

import com.example.oBootMybatis01.model.Dept;
import com.example.oBootMybatis01.model.DeptVO;

public interface DeptDao {
	List<Dept> 	deptSelect();
	void 		insertDept(DeptVO deptVO);
	void		selListDept(HashMap<String, Object> map);
}
