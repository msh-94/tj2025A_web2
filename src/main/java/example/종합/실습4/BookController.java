package example.종합.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {// class start
    private final BookService bookService;
    // 책 단일 등록
    @PostMapping("")
    public ResponseEntity<?> bookAdd(@RequestBody BookDto dto){
        int bno = bookService.bookAdd(dto);
        return ResponseEntity.ok(bno);
    }// func end
    // 대출 기록 검색
    @GetMapping("")
    public ResponseEntity<?> rentalPrint(@RequestParam String member){
        List<RentalsDto> list = bookService.rentalPrint(member);
        return ResponseEntity.ok(list);
    }// func end
    // 책 일괄 등록
    @PostMapping("/all")
    public ResponseEntity<?> bookAllAdd(@RequestBody List<BookDto> list){
        List<Integer> result = bookService.bookAllAdd(list);
        return ResponseEntity.ok(result);
    }// func end
}// class end
