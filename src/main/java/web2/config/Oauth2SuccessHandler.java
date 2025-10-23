package web2.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web2.servicce.JwtService;
import web2.servicce.UserService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Oauth2SuccessHandler implements AuthenticationSuccessHandler { // class start
    private final JwtService jwtService;
    private final UserService userService;

    // [1] AuthenticationSuccessHandler 구현체를 만든다
    // [2] onAuthenticationSuccess 메소드 구현한다

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 타사 로그인 성공 이후 로직 커스텀( 실패 커스텀 없다 )
        // [3] 로그인 성공한 회원의 타사 발급한 토큰 정보
        System.out.println( authentication ); // authentication 인증 ( 토큰 , 개인정보 등 )

        // 3-1 : oauth2 관련 라이브러리 설치 : implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
        // 3-2 : 로그인 성공한 토큰 확인 , OAuth2AuthenticationToken , 타사의 회사명
        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
        System.out.println("authToken = " + authToken);
        // 3-3 : 로그인 성공한 회원의 동의항목(정보) , Oauth2User
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal(); // Principal() 로그인정보
        System.out.println("oauth2User = " + oauth2User);

        // [4] google / kakao 인지 식별
        String provider = authToken.getAuthorizedClientRegistrationId(); // 등록된 공급자 ID : google , kakao
        System.out.println("provider = " + provider);
        String uid = null; String name = null; // 동의학목 정보
        if (provider.equals("google")){
            uid = oauth2User.getAttribute("email"); // oauth2User.getAttribute("동의항목명")
            name = oauth2User.getAttribute("name");
        }

        // [7] oauth2 정보를 데이터베이스 저장
        userService.oauth2UserSignUp(uid,name);

        // [5] 자사(우리)서버와 타사서버 통합 로그인( web : 토큰/쿠키 vs 세션 ) , 권한은 USER 정의
        Cookie cookie = new Cookie("loginUser",jwtService.createToken(uid,"USER"));
        cookie.setHttpOnly(true); cookie.setSecure(false);
        cookie.setPath("/"); cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        // [6] 로그인 성공시 어디로 이동할지 ( 프론트엔드 루트 )
        // response.sendRedirect("http://localhost:5173/"); // 리액트 서버
        response.sendRedirect("/"); // 자바서버 메인경로 localhost:8080

    }// func end






}//  class end
