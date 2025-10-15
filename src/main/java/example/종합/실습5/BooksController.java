package example.종합.실습5; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/tbook")
@RequiredArgsConstructor
public class BooksController { // class start
    private final BooksService booksService;

    // [1] books 테이블에 price 가격(int)
    @PutMapping("/price")
    public ResponseEntity<?> priceAdd(){
        int result = booksService.priceAdd();
        return ResponseEntity.ok(result);
    }// func end

    // [2] books 테이블에 title 책이름(longtext)로 수정
    @PutMapping("/title")
    public ResponseEntity<?> titleUpdate(){
        int result = booksService.titleUpdate();
        return ResponseEntity.ok(result);
    }// func end

    // [3] 평균재고보다 많은 도서 조회
    @GetMapping("/avg")
    public ResponseEntity<?> getBooks(){
        List<BooksDto> list = booksService.getBooks();
        return ResponseEntity.ok(list);
    }// func end

    // [4] 가장많이 대출한 도서 조회
    @GetMapping("/first")
    public ResponseEntity<?> firstBook(){
        String result = booksService.firstBook();
        return ResponseEntity.ok(result);
    }// func end
    // 테스트
    @GetMapping
    public void get(){
        System.out.println("booksService = " + booksService);
    }

}// class end
