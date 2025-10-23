package example.종합.영화플랫폼.controller; // 패키지명

import example.종합.영화플랫폼.model.dto.DisBoardDto;
import example.종합.영화플랫폼.service.DisBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("disboard")
@RequiredArgsConstructor @CrossOrigin( value = "http://localhost:5173/")
public class DisBoardController { // class start
    // [*]
    private final DisBoardService disBoardService;

    // [1] 등록
    @PostMapping("")
    public ResponseEntity<Boolean> disBoardAdd(@RequestBody DisBoardDto dto){
        boolean result = disBoardService.disBoardAdd(dto);
        return ResponseEntity.ok().body(result);
    }// func end

    // [2] 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> disBoardDelete(@RequestParam int mno , @RequestParam int dpwd){
        boolean result = disBoardService.disBoardDelete(mno, dpwd);
        return ResponseEntity.ok().body(result);
    }// func end

    // [3] 개별조회
    @GetMapping("")
    public ResponseEntity<List<DisBoardDto>> disBoardPrint(@RequestParam int mno){
        List<DisBoardDto> result = disBoardService.disBoardPrint(mno);
        return ResponseEntity.ok().body(result);
    }// func end
}// class end
