package com.example.oBootMybatis01.dao;

import java.util.List;

import com.example.oBootMybatis01.model.Member1;

public interface Member1Dao {
	int				memCount(String id);		//Member1의 Count
	List<Member1>	listMem(Member1 member1);
	int 			transactionInsertUpdate();
	int 			transactionInsertUpdate3();
}
