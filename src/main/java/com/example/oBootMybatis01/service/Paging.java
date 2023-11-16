package com.example.oBootMybatis01.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	// 현재 페이지
					     //-->2		// 한페이지에 게시글 몇개씩 보여줄지
	private int currentPage = 1;	private int rowPage = 10;
	// 페이지블록의 개수
	private int pageBlock = 10;
	
	// start와 엔드는 한페이지 글을 1(St)~10(E), 11(S)~20(E)으로 끊는 용도로 사용
	// 2페이지를 눌렀을때 start는 11
	private int start;				private int end;
	// 페이지블록에서 시작페이지			// 페이지블록에서 엔드페이지(공갈처리 필요)
	private int startPage;			private int endPage;
	// 실제 사람수						// 실제 생설될 페이지 개수 
	private int total;				private int totalPage;
	
	//	태초에		  23				null 로 들어옴 --> 다음 2로들어오면
	//  								처음에 null로들어올땐 currentPage=1 활용 null 아닐경우 조건 if (currentPage1 != null)아래 로직에 의해
	//									currentPage 값 수정
	public Paging(int total, String currentPage1) {
		this.total = total;		// 23 
		if (currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1);	// --> 2
		}
		//			1					10
		start = (currentPage - 1 ) * rowPage + 1; // 시작시 1	 --> 11  
		end   = start + rowPage - 1;			  // 시작시 10	 --> 20  
		//									23		10			 3페이지로 세팅
		//							double(total)먼저실행 후 double / int = double 후 ceil로 정수형
		totalPage = (int) Math.ceil((double)total/ rowPage);  // 시작시 3 5 14
		//				2				2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 시작시 1 --> 1
		endPage   = startPage + pageBlock - 1;  // 10 --> 10
		
		//	 10				14 		<-- 흐름 태우는것
		//	  IF 10		   7		<-- 공갈페이지방지: endPage는 10인데 totalPage는 7인경우 8,9,10 이 비므로, endPage를 totalPage로 맞춰준다.
		if ( endPage > totalPage) {
			 endPage = totalPage;
		}
	}
}
