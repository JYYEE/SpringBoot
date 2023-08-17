package com.minjung.bangbang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	// 이것만 붙이면 자동으로 설정파일이 됨
//@EnableWebMvc	// 우린 JSP별도 설정했으므로 필요없음
public class MyConfig  implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("요기가 실행되었는지 check?");	// 설정이 실행되는지 확인용
		registry.addResourceHandler("/upload/**")             // 웹 접근 경로(주소표시줄 경로)
		        .addResourceLocations("file:///d:/upload/");  // 서버내 실제 경로(물리적 실제 경로)
		// resources 폴더에 두면 톰캣이 늦게 가져다가 놓음
		// 디버깅용으로는 외부에 두고 배포할 때 resources 이용
	}

}
