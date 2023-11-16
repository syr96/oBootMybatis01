package com.example.oBootMybatis01.repository;

import java.util.List;
import java.util.Optional;

import com.example.oBootMybatis01.domain.Member;

public interface MemberJpaRepository {
	Member		 			save(Member member);
	List<Member> 			findAll();
	Optional<Member>		findById(Long memberId);
	void 					updateByMmember(Member member);
}
