package example2.day01;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/exam")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    // 1. 등록
    @PostMapping // http://localhost:8080/api/exam
    // {"col1" : "1" , "col2" : "유재석" , "col3" : "90.5"}
    public ResponseEntity<?> post(@RequestBody ExamEntity examEntity){
        ExamEntity saveEntity = examService.post(examEntity);
        return ResponseEntity.ok(saveEntity);
    }// func end

    // 2. 전체조회
    @GetMapping// http://localhost:8080/api/exam
    public ResponseEntity<?> get(){
        List<ExamEntity> entityList = examService.get();
        return ResponseEntity.ok(entityList);
    }// func end

}// class end
