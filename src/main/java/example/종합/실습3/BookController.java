package example.종합.실습3; // 패키지명

import lombok.RequiredArgsConstructor;
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
    public boolean bookRent(@RequestBody RentalsDto dto){
        return bookService.bookRent(dto);
    }// func end

    // [2] 반납
    @PostMapping("/return")
    public boolean bookReturn(@RequestBody RentalsDto dto){
        return bookService.bookReturn(dto);
    }// func end
}// class end
