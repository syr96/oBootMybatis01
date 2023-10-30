package com.oracle.oBootMybatis01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.oracle.oBootMybatis01.model.Member1;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class Member1DaoImpl implements Member1Dao {
	
	private final PlatformTransactionManager transactionManager;
	// Mybatis DB 연동
	private final SqlSession session;

	@Override
	public int transactionInsertUpdate() {
		int result = 0;
		System.out.println("Member1DaoImpl transactionInsertUpdate Start...");
		Member1 member1 = new Member1();
		Member1 member2 = new Member1();
		
		try {
			// 두개의 transaction Test 성공과 실패
			// 결론 -> SqlSession 은 하나 실행할 때마다 자동 Commit
			// Transaction관리는 transactionManager의 getTransaction을 가지고 상태따라 설정
			member1.setId("1005");
			member1.setPassword("2345");
			member1.setName("강유6");
			
			result = session.insert("insertMember1", member1);
			System.out.println("Member1DaoImpl transactionInsertUpdate member1 result -> " + result);
			
			//같은 PK로 실패 유도
			member2.setId("1005");
			member2.setPassword("3457");
			member2.setName("이순신7");
			result = session.insert("insertMember1", member2);
			System.out.println("Member1DaoImpl transactionInsertUpdate member2 result -> " + result);
		} catch (Exception e) {
			System.out.println("Member1DaoImpl transactionInsertUpdate Exception -> " + e.getMessage());
			result = -1;
		}
		return result;
	}

	@Override
	public int transactionInsertUpdate3() {
		int result = 0;
		System.out.println("Member1DaoImpl transactionInsertUpdate Start...");
		Member1 member1 = new Member1();
		Member1 member2 = new Member1();
		
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			// 두개의 transaction Test 성공과 실패
			// 결론 -> SqlSession 은 하나 실행할 때마다 자동 Commit
			// Transaction관리는 transactionManager의 getTransaction을 가지고 상태따라 설정
			member1.setId("1005");
			member1.setPassword("2345");
			member1.setName("강유6");
			
			result = session.insert("insertMember1", member1);
			System.out.println("Member1DaoImpl transactionInsertUpdate member1 result -> " + result);
			
			//같은 PK로 실패 유도
			member2.setId("1006");
			member2.setPassword("3457");
			member2.setName("이순신7");
			result = session.insert("insertMember1", member2);
			System.out.println("Member1DaoImpl transactionInsertUpdate member2 result -> " + result);
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			System.out.println("Member1DaoImpl transactionInsertUpdate Exception -> " + e.getMessage());
			result = -1;
		}
		return result;
	}

}
