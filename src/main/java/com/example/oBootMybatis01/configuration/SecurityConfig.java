package com.example.oBootMybatis01.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration			// 시큐리티의 환경설정
public class SecurityConfig {
	
	@Bean			//비밀번호를 인코딩(해싱)로 암호화 하고  반환하는 메소드 
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean							// 시큐리티 설정 메소드
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();		//  CSRF(Cross-Site Request Forgery) 방어를 비활성화하는 설정입니다.
		http.authorizeRequests()	// http.authorizeRequests(): 스프링 시큐리티에서 요청에 대한 접근 권한을 설정하는 메서드를 호출합니다
			.anyRequest()			// .anyRequest():  "어떠한 요청에 대해서도"를 나타내며, 이어지는 설정은 모든 요청에 대해 적용
			.permitAll();			//	.permitAll():  모든 요청에 대한 액세스를 허용하도록 설정
		
		return http.build();
	}
}
