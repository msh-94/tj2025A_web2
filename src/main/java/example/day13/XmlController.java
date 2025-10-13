package example.day13; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController { // class start
    // [*]
    private final XmlMapper xmlMapper;

    // [1] 등록 , { "name" : "유재석" , "kor" : "90" , "math" : "70" }
    @PostMapping("") // http://localhost:8080/xml
    public ResponseEntity<?> save(@RequestBody StudentDto dto ){
        // < ? > : 제네릭타입에 ? 넣으면 모든 타입을 지칭한다 , 와일드카드
        System.out.println("dto = " + dto); // soutp , save 실행전
        xmlMapper.save( dto ); // ========= SQL 실행 ========
        System.out.println("dto = " + dto); // soutp , save 실행후
        return ResponseEntity.ok( dto ); // 제네릭 ? 이므로 모든 자료가 대입된다
    }// func end

    // [2] 전체조회
    @GetMapping("")
    public ResponseEntity< ? > findAll(){
        List< StudentDto > list = xmlMapper.findAll();
        return ResponseEntity.ok(list);
    }// func end

    // [3] 개별 학생 조회
    @GetMapping("/find")
    public ResponseEntity< ? > find(@RequestParam int sno){
        StudentDto dto = xmlMapper.find(sno);
        return ResponseEntity.ok(dto);
    }// func end

    // [4] 개별 학생 삭제
    @DeleteMapping("")
    public ResponseEntity< ? > delete(@RequestParam int sno){
        int result = xmlMapper.delete(sno);
        return ResponseEntity.ok(result);
    }// func end

    // [5] 개별 학생 수정
    @PutMapping("")
    public ResponseEntity< ? > update(@RequestBody StudentDto dto){
        int result = xmlMapper.update(dto);
        return ResponseEntity.ok(result);
    }// func end

}// class end
