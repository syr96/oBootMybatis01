package com.oracle.oBootMybatis01.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	private int currentPage = 1;	private int rowPage = 10;
	private int pageBlock = 10;
	private int start;				private int end;
	private int startPage;			private int endPage;
	private int total;				private int totalPage;
	
	//					19				null
	public Paging(int total, String currentPage1) {
		this.total = total;		// 19
		if(currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1); // 2
		}
		//			1					10
		start = (currentPage - 1) * rowPage + 1;	// 시작 시 1	11
		end = start + rowPage - 1;					// 시작 시 10	20
		//									19		/	10
		totalPage = (int) Math.ceil((double) total / rowPage);	// 시작 시 2
		//			2				2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 시작 시 1
		endPage = startPage + pageBlock - 1; // 10
		//	10			14
		if(endPage > totalPage) {
			endPage = totalPage; // 공갈 페이지를 없애기 위해 하는 작업이다
		}
	}
}
