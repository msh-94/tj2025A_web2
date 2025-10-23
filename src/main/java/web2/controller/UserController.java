package web2.controller; // 패키지명

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web2.model.dto.UserDto;
import web2.servicce.JwtService;
import web2.servicce.UserService;

@RestController @RequestMapping("/user")
@RequiredArgsConstructor
public class UserController { // class start
    private final UserService userService;
    private final JwtService jwtService;

    /**
     * 회원가입
     *
     * @method post
     * @url http://localhost:8080/user/signup
     * @test { "uid" : "qwe" , "upwd" : "qwe" , "uname" : "유재석" , "uphone" : "010-2222-3333" , "urole" : "USER" }
     * @param userDto @RequestBody
     * @return uno
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto){
        int result = userService.signUp(userDto);
        if (result > 0){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(400).body(result);
        }// if end
    }// func end

    ///**
    // * 로그인
    // * + 세션 : 자바 웹서버(톰캣)의 임시 저장소
    // *
    // * @method post
    // * @url http://localhost:8080/user/login
    // * @test { "uid" : "qwe" , "upwd" : "qwe" }
    // * @param userDto @RequestBody
    // * @return dto
    // */
    //@PostMapping("/login")
    //public ResponseEntity<?> login(@RequestBody UserDto userDto , HttpSession session){
    //    UserDto result = userService.login(userDto);
    //    if (result != null){
    //        session.setAttribute("loginUser" , result.getUid());
    //        return ResponseEntity.ok(result);
    //    }else {
    //        return ResponseEntity.status(400).body(result);
    //    }// if end
    //}// func end

    /**
     * 로그인
     * + 쿠키 : 클라이언트 브라우저 의 임시 저장소 , 세션:서버 / 쿠키:클라이언트
     *
     * @method post
     * @url http://localhost:8080/user/login
     * @test { "uid" : "qwe" , "upwd" : "qwe" }
     * @param userDto @RequestBody
     * @return dto
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto , HttpServletResponse response){
        UserDto result = userService.login(userDto);
        if (result != null){
            // * 로그인 정보를 세션에 저장하면 서버이므로 안전하다 , 쿠키(클라이언트) 저장하면 위험하다
            // 안전장치 필요하다
            // Cookie cookie = new Cookie( "쿠키명" , 값 ); // 주로 사용자들의 설정값/임시저장소
            // response.addCookie( 생성한쿠키 );
            // Cookie cookie = new Cookie( "loginUser" , result.getUid() );
            // ****** 쿠키에 저장하는 회원정보를 토큰으로 저장하기 *******
            Cookie cookie = new Cookie( "loginUser" , jwtService.createToken( result.getUid(), result.getUrole() ));
            // 클라이언트 에서 해당 쿠키를 노출(탈취) 방지 = 주로 민감한 정보 httpOnly 설정한다
            cookie.setHttpOnly( true ); // .setHttpOnly( true ) : 무조건 http 에서만 사용 , 즉] JS로 접근 불가능
            cookie.setSecure( false ); // .setSecure( true ) : http 이용하여 탈취 하더라도 암호화 , 단 https 에서만 가능
            // + 설정
            cookie.setPath("/"); // 쿠키에 접근할수 있는 경로
            cookie.setMaxAge( 60 * 60 ); // 쿠키의 유효시간(초) , 1시간
            response.addCookie( cookie ); // 생성한 쿠키를 클라이언트에게 반환한다
        }// if end
        return ResponseEntity.ok(result);
    }// func end

    /**
     * 내정보 조회
     * 쿠키에서 로그인한 회원의 아이디 가져와서 조회하기
     *
     * @method get
     * @url http://localhost:8080/user/myinfo
     * @param request ( uid )
     * @return dto
     */
    @GetMapping("/myinfo")
    public ResponseEntity<?> myInfo( HttpServletRequest request ){ // 쿠키를 활용한 로그인상태를 확인
        // 3-1 : 현재 클라이언트(브라우저) 저장된 모든 쿠키 가져오기
        Cookie[] cookies = request.getCookies();
        // 3-2 : 반복문 이용한 특정한 쿠키명 찾기
        System.out.println("cookies = " + cookies);
        if (cookies != null){ // 만약에 쿠키들이 존재하면
            for (Cookie c : cookies){ // 하나씩 쿠키들을 반복하여
                if (c.getName().equals("loginUser")){ // "loginUser" 쿠키명과 같다면
                    // String uid = c.getValue(); // 쿠키의 저장된 값 반환 ex] uid
                    // ******* 쿠키의 저장된 토큰 반환하기 *******
                    String token = c.getValue(); // 쿠키의 저장된 토큰 반환
                    boolean checked = jwtService.checkToken(token); // 토큰 검증
                    System.out.println(checked);
                    if (checked){ // 만약에 토큰이 유효하면
                        String uid = jwtService.getUid(token);
                        System.out.println("uid = " + uid);
                        // 3-3 : 서비스를 호출하여 내정보 조회
                        UserDto result = userService.myInfo(uid);
                        return ResponseEntity.ok(result); // 로그인 상태로 회원정보 조회
                    }// if end
                    // 만약에 토큰이 유효하지 않으면
                    return ResponseEntity.ok(null); // 토큰 검증 실패
                }// if end
            }// for end
        }// if end
        return ResponseEntity.ok(null);
    }// func end

    /**
     * 로그아웃
     * 쿠키에서 해당하는 쿠키명 덮어쓰기로 null 저장
     *
     * @method get
     * @url http://localhost:8080/user/logout
     * @param response
     * @return boolean
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logout( HttpServletResponse response){
        // 4-1 : 삭제할 쿠키명을 null 값으로 변경한다
        Cookie cookie = new Cookie( "loginUser" , null );
        cookie.setHttpOnly( true );
        cookie.setSecure( false );
        cookie.setPath( "/" );
        cookie.setMaxAge( 0 ); // 즉시 삭제 : 0초
        response.addCookie(cookie); // 동일한 쿠키명으로 null 저장하면 기존 쿠키명 사라진다

        // 세션 : 서버에 저장하는 임시 저장소 이므로 서버가 종료되면 사라진다
        // 쿠키 : 클라이언트에 저장하는 임시 저장소 이므로 서버가 종료되도 유지된다

        return ResponseEntity.ok(true);
    }// func end

}// class end
