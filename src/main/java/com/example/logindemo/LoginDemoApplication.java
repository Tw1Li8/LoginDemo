package com.example.logindemo;
// 이 클래스가 속한 패키지를 선언

import org.springframework.boot.SpringApplication;
// Spring Boot 애플리케이션을 실행하기 위한 클래스를 임포트

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Spring Boot 자동 설정을 활성화하는 어노테이션 임포트

@SpringBootApplication
// @Configuration, @EnableAutoConfiguration, @ComponentScan을 결합한 어노테이션
// 이 패키지와 하위 패키지의 컴포넌트들을 자동으로 스캔하고 Bean으로 등록합니다.

public class LoginDemoApplication {
// 애플리케이션의 메인 클래스를 정의

    public static void main(String[] args) {
        // 이 어플리케이션의 진입점
        
        SpringApplication.run(LoginDemoApplication.class, args);
        // Spring Boot 어플리케이션 시작
        // 내장 웹 서버(Tomcat)를 구동하고, 설정된 모든 Bean을 초기화합니다.
    }

}