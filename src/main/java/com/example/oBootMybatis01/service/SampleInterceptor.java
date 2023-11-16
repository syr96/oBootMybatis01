package com.example.oBootMybatis01.service;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SampleInterceptor implements HandlerInterceptor {
	public SampleInterceptor() {
		
	}
	
	// 3번 수행
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("post handle.......");
		String ID = (String)modelAndView.getModel().get("id");
		int memCnt = (Integer)modelAndView.getModel().get("memCnt");
		System.out.println("SampleInterceptor post handle memCnt:" + memCnt );
		if(memCnt < 1) {
			System.out.println("memCnt Not Exists");
			request.getSession().setAttribute("ID", ID);
			// User가 존재하지 않으면 User interCeptor Page(회원등록) 이동
			response.sendRedirect("doMemberWrite");
			
		} else {
			System.out.println("memCnt Exists");
			request.getSession().setAttribute("ID", ID);
			// User가 존재하지않으면 User interCeptor Page(회원등록) 이동
			response.sendRedirect("doMemberList");
		}
	}
	
	// 1번 수행
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		System.out.println("pre handle.......");
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);
		
		return true;
	}
}
