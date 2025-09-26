package example.종합.실습3; // 패키지명

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping("/books")
@Log4j2 // 로그(기록) 처리하는 어노테이션 제공
public class BookController { // class start
    private final BookService bookService;

    // print 함수 대신에 로그함수 사용해보기 = 부가기능 제공 , 제약조건 등
    @GetMapping("/log") public void log(){
        System.out.println("개발단계 에서는 print 정말 많이 작성하자");
        // log.XXXX : 출력함수 처럼 출력하는 메시지 함수 이면서 부가기능(파일처리/제약조건등)
        log.debug(" 테스트 과정 사용된다 "); // 테스트(개발)과정 에서 메시지
        log.info(" 서비스의 흐름/상태 확인할때 사용된다 "); // 운용 과정 메시지
        log.warn(" 잠재적인 문제일때 사용된다 "); // 유지보수 과정 메시지
        log.error(" 예외/오류 상황 사용된다 "); // 운용/유지보수 과정 메시지
    }

    // [1] 대출
    @PostMapping("/rent")
    public ResponseEntity<Boolean> bookRent(@RequestBody RentalsDto dto){
        log.debug("[대여신청]" + dto);
        boolean result = false;
        try {
            result = bookService.bookRent(dto);  // 만약에 커밋이면
            log.debug("[대여성공]" + dto);
            return ResponseEntity.ok().body(result);
        } catch (RuntimeException e) { // 만약에 롤백이면 , e.getMessage() : 예외 메시지
            log.debug("[대여실패]" + e.getMessage());
            return ResponseEntity.status(405).body(result);
        }// try catch end
    }// func end

    // [2] 반납
    @PostMapping("/return")
    public ResponseEntity<Boolean> bookReturn(@RequestBody RentalsDto dto){
        boolean result = false;
        try {
            result = bookService.bookReturn(dto);
            return ResponseEntity.ok().body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(405).body(result);
        }// try catch end
    }// func end
}// class end
