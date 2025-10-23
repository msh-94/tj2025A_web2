package web2.controller; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController { // class start
    @GetMapping("/dashboard") // http://localhost:8080/api/admin/dashboard
    public String dashboard(){
        return "관리자 API 요청 성공";
    }// func end
}// class end
