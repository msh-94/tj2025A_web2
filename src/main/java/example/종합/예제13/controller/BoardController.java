package example.종합.예제13.controller;// 패키지명

import example.종합.예제13.model.dto.BoardDto;
import example.종합.예제13.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
//@CrossOrigin( value = "허용할주소" ) // CORS( 서로 다른 서버간의 요청/응답 허용 ) 정책을 설정
@CrossOrigin( value = "http://localhost:5173" ) // 리액트서버 와 CORS 통신을 허용
public class BoardController { // class start
    private final BoardService boardService;

    // [1] 등록
    @PostMapping("")
    public ResponseEntity<Boolean> boardWrtie(@RequestBody BoardDto boardDto){
        boolean result = boardService.boardWrite(boardDto);
        return ResponseEntity.ok().body(result);
    }// func end

    // [2] 전체조회
    @GetMapping("")
    public ResponseEntity<List<BoardDto>> boardPrint(){
        List<BoardDto> result = boardService.boardPrint();
        return ResponseEntity.ok().body(result);
    }// func end

    // [3] 개별조회
    @GetMapping("/find")
    public ResponseEntity<BoardDto> boardFind(@RequestParam int bno){
        BoardDto result = boardService.boardFind(bno);
        return ResponseEntity.ok().body(result);
    }// func end

    // [4] 개별 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> boardDelete(@RequestParam int bno){
        boolean result = boardService.boardDelete(bno);
        return ResponseEntity.ok().body(result);
    }// func end

    // [5] 개별 수정
    @PutMapping("")
    public ResponseEntity<Boolean> boardUpdate(@RequestBody BoardDto boardDto){
        boolean result = boardService.boardUpdate(boardDto);
        return ResponseEntity.ok().body(result);
    }// func end

}// class end
