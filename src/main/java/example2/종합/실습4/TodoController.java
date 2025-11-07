package example2.종합.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/task4")
@RequiredArgsConstructor
@CrossOrigin( origins = "*" )
public class TodoController {
    //[*]
    private final TodoService todoService;

    // [1] 등록
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDto dto){
        return ResponseEntity.ok(todoService.createTodo(dto));
    }// func end

    // [2] 전체조회
    @GetMapping
    public ResponseEntity<?> getTodoList(){
        return ResponseEntity.ok(todoService.getTodoList());
    }// func end


}// class end
