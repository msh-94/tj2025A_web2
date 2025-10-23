package web2.controller; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web2.servicce.JwtService;

@RestController @RequestMapping("/api/jwt") // http://localhost:8080/api/jwt
@RequiredArgsConstructor
public class JwtController { // class start
    private final JwtService jwtService;

    // [1] 토큰 생성
    // http://localhost:8080/api/jwt/create?데이터=유재석
    // token : eyJhbGciOiJub25lIn0.eyJrZXkiOiLsnKDsnqzshJ0iLCJpYXQiOjE3NjEwOTQ4NTYsImV4cCI6MTc2MTA5NDkxNn0.
    //@GetMapping("/create")
    //public ResponseEntity<?> 토큰생성(@RequestParam String 데이터){
    //    String token = jwtService.토큰생성(데이터);
    //    return ResponseEntity.ok(token);
    //}// func end
    //
    //// [2] 토큰 검증
    //// http://localhost:8080/api/jwt/read?토큰=
    //@GetMapping("/read")
    //public ResponseEntity<?> 토큰검증(@RequestParam String 토큰){
    //    boolean result = jwtService.토큰검증(토큰);
    //    return ResponseEntity.ok(result);
    //}// func end
    //
    //// [3] 토큰 값 추출
    //// http://localhost:8080/api/jwt/value?토큰=
    //@GetMapping("/value")
    //public ResponseEntity<?> 토큰값추출(@RequestParam String 토큰){
    //    String value = jwtService.값추출(토큰);
    //    return ResponseEntity.ok(value);
    //}// func end

}// class end
