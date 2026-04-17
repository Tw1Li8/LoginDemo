package com.example.logindemo.controller;
// 컨트롤러 클래스들이 위치하는 controller 패키지를 선언

import org.springframework.security.core.annotation.AuthenticationPrincipal;
// 현재 인증된 사용자 정보를 주입받기 위한 어노테이션 임포트

import org.springframework.security.oauth2.core.user.OAuth2User;
// OAuth2 인증된 사용자의 정보를 담는 인터페이스 임포트

import org.springframework.web.bind.annotation.GetMapping;
// HTTP GET 요청을 처리하는 메서드에 붙이는 어노테이션 임포트

import org.springframework.web.bind.annotation.RestController;
// REST API 컨트롤러임을 나타내는 어노테이션 임포트
// @Controller + @ResponseBody 의 조합

import java.util.Map;
// Map 인터페이스를 가져옴. 키-값 쌍의 데이터를 저장

@RestController
// 이 클래스가 REST 컨트롤러임을 선언
// 모든 메서드의 반환값이 자동으로 JSON으로 변환

public class LoginController {
// 로그인 관련 요청을 처리하는 컨트롤러 클래스

    @GetMapping("/")
    // HTTP GET 요청으로 루트 경로("/")에 접근할 때 이 메서드가 실행

    public Map<String, Object> index(@AuthenticationPrincipal OAuth2User principal) {
        // @AuthenticationPrincipal: 현재 로그인한 사용자의 OAuth2User 객체를 자동으로 주입받습니다.
        // principal에는 Google 등 OAuth2 제공자로부터 받은 사용자 정보가 담겨 있습니다.

        return principal.getAttributes();
        // 로그인한 사용자의 프로필 정보(이름, 이메일, 프로필 사진 URL 등)를
        // Map 형태로 반환
        // @RestController이므로 자동으로 JSON 형식으로 변환되어 응답
    }
}