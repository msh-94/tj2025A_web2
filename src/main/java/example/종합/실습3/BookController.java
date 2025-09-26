package example.종합.실습3; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping("/books")
public class BookController { // class start
    private final BookService bookService;
    // [1] 대출
    @PostMapping("/rent")
    public ResponseEntity<Boolean> bookRent(@RequestBody RentalsDto dto){
        boolean result = bookService.bookRent(dto);
        return ResponseEntity.ok().body(result);
    }// func end

    // [2] 반납
    @PostMapping("/return")
    public ResponseEntity<Boolean> bookReturn(@RequestBody RentalsDto dto){
        boolean result = bookService.bookReturn(dto);
        return ResponseEntity.ok().body(result);
    }// func end
}// class end
