package example2.day04.controller;

import example2.day04.service.TodoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // [1] TodoRepository 2-1 , 3-1
    @GetMapping("/query1") // http://localhost:8080/api/todo/query1?title=책 읽기
    public ResponseEntity<?> query1(@RequestParam String title){
        return ResponseEntity.ok(todoService.query1(title));
    }// func end

    // [2] TodoRepository 2-2 , 3-2
    @GetMapping("/query2") // http://localhost:8080/api/todo/query2?title=책 읽기&content=이펙티브 자바 3장 읽기
    public ResponseEntity<?> query2(@RequestParam String title, @RequestParam String content){
        return ResponseEntity.ok(todoService.query2(title,content));
    }// func end

    // [3] TodoRepository 2-3 , 3-3
    @GetMapping("/query3") // http://localhost:8080/api/todo/query3?keyword=책
    public ResponseEntity<?> query3(@RequestParam String keyword){
        return ResponseEntity.ok(todoService.query3(keyword));
    }// func end

    // [4] 페이징처리
    @GetMapping("/page") // http://localhost:8080/api/todo/page?page=1&size=3
    public ResponseEntity<?> page(
            @RequestParam(defaultValue = "1") int page , // 조회할 페이지 번호
            @RequestParam(defaultValue = "3") int size ){ // 조회 페이지에 조회할 자료의 개수
        return ResponseEntity.ok(todoService.page(page,size));
    }// func end

    // [5] 2-5
    @GetMapping("/page2") // http://localhost:8080/api/todo/page2?keyword=책&page=1&size=3
    public ResponseEntity<?> page2(
            @RequestParam String keyword ,
            @RequestParam int page ,
            @RequestParam int size ){
        return ResponseEntity.ok( todoService.page2( keyword , page , size ));
    }// func end

}// class end
