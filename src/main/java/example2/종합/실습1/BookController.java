package example2.종합.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/task1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // [1] 도서 등록
    @PostMapping // http://localhost:8080/task1/book
    // { "bno" : "1" , "name" : "자바" , "writer" : "유재석" , "publisher" : "더조은" }
    public ResponseEntity<?> save(@RequestBody BookEntity bookEntity){
        boolean result = bookService.save(bookEntity);
        return ResponseEntity.ok(result);
    }// func end

    // [2] 도서 전체 조회
    @GetMapping // http://localhost:8080/task1/book
    public ResponseEntity<?> get(){
        List<BookEntity> list = bookService.get();
        return ResponseEntity.ok(list);
    }// func end

    // [3] 특정 도서 수정
    @PutMapping // http://localhost:8080/task1/book
    // { "bno" : "1" , "name" : "스프링" , "writer" : "강호동" , "publisher" : "컴퓨터" }
    public ResponseEntity<?> put(@RequestBody BookEntity bookEntity){
        boolean result = bookService.put(bookEntity);
        return ResponseEntity.ok(result);
    }// func end

    // [4] 특정 도서 삭제
    @DeleteMapping // http://localhost:8080/task1/book?bno=
    public ResponseEntity<?> delete(@RequestParam int bno){
        boolean result = bookService.delete(bno);
        return ResponseEntity.ok(result);
    }// func end

}// class end
