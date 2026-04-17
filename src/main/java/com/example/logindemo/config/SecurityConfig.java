package com.example.logindemo.config;
// 설정 클래스들이 위치하는 config 패키지를 선언

import org.springframework.context.annotation.Bean;
// 메서드의 반환값을 Spring Bean(spring_boot가 관리하는 component와 같은 개념)으로
// 등록하는 어노테이션 임포트

import org.springframework.context.annotation.Configuration;
// 이 클래스가 Spring 설정 클래스임을 나타내는 어노테이션 임포트
import org.springframework.security.config.Customizer;
// Spring Security의 기본 설정을 적용하기 위한 함수형 인터페이스 임포트

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// HTTP 보안 설정을 구성하기 위한 빌더 클래스 임포트

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// Spring Security의 웹 보안 기능을 활성화하는 어노테이션 임포트
//이 매서드 내에 로그인을 담당하는 OAuth2(USB 로그인 표준 규격)를 쓸 수 있음
// Google,Kakao,Apple,Github 등등 OAuth2 방식을 사용

import org.springframework.security.web.SecurityFilterChain;
// 보안 필터 체인 인터페이스 임포트
// 사용자의 요청에 의해 적용될 보안 필터들의 체인,집합

@Configuration
// 이 클래스가 Spring의 설정 클래스임을 선언
// @EnableWebSecurity 안에 이미 들어 있지만 가독성을 위해 명시적 사용

@EnableWebSecurity
// Spring Security의 웹 보안 지원을 활성화합니다.
// SecurityFilterChain을 자동으로 등록합니다.

public class SecurityConfig {
// 보안 관련 설정을 담당하는 클래스 선언

    @Bean
    // 이 메서드의 반환값을 Spring 컨테이너에 Bean으로 등록합니다.

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity 객체를 받아 보안 필터 체인을 구성하는 메서드입니다.
        // Spring이 자동으로 HttpSecurity 객체를 주입. 아이고 편하다

        http
                .csrf(csrf -> csrf.disable())
                // CSRF(Cross-Site Request Forgery) 보호를 비활성화
                // 테스트 환경에서 편의를 위해 비활성화 하는 것이지
                // 실제 배포 환경에서는 반드시 활성화

                .authorizeHttpRequests(auth -> auth
                                .anyRequest().authenticated()
                        // 모든 HTTP 요청에 대해 인증(로그인)을 요구
                )
                .oauth2Login(Customizer.withDefaults());
                // 로그인 기능을 활성화
                // 인증되지 않은 사용자를 로그인 페이지를 리다이렉팅

        // OAuth2 로그인 기능을 활성화
        // Customizer.withDefaults()는 기본 설정을 적용합니다.
        // application.properties/yml에 설정된 OAuth2 제공자(Google 등)를 사용
        return http.build();
        // 설정된 HttpSecurity 객체를 기반으로 SecurityFilterChain을 생성하여 반환합니다.
    }
}