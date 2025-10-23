package example.종합.예제13.controller; // 패키지명

import example.종합.예제13.model.dto.TaskDto;
import example.종합.예제13.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/task5")
@RequiredArgsConstructor @CrossOrigin( value = "http://localhost:5173" )
public class TaskController { // class start
    private final TaskService taskService;

    // [1] 등록
    @PostMapping("")
    public ResponseEntity<Boolean> taskAdd(@RequestBody TaskDto taskDto){
        boolean result = taskService.taskAdd(taskDto);
        return ResponseEntity.ok().body(result);
    }// func end

    // [2] 전체조회
    @GetMapping("")
    public ResponseEntity<List<TaskDto>> taskPrint(){
        List<TaskDto> result = taskService.taskPrint();
        return ResponseEntity.ok().body(result);
    }// func end

    // [3] 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> taskDelete(@RequestParam int tno){
        boolean result = taskService.taskDelete(tno);
        return ResponseEntity.ok().body(result);
    }// func end
}// class end
