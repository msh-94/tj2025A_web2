package example.종합.영화플랫폼.controller; // 패키지명

import example.종합.영화플랫폼.model.dto.MovieDto;
import example.종합.영화플랫폼.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@CrossOrigin( value = "http://localhost:5173/")
public class MovieController { // class start
    // [*]
    private final MovieService movieService;

    // [1] 등록
    @PostMapping("")
    public ResponseEntity<Boolean> movieAdd(@RequestBody MovieDto dto){
        boolean result = movieService.movieAdd(dto);
        return ResponseEntity.ok().body(result);
    }// func end

    // [2] 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> movieDelete(@RequestParam int mno , @RequestParam int mpwd){
        boolean result = movieService.movieDelete(mno , mpwd);
        return ResponseEntity.ok().body(result);
    }// func end

    // [3] 전체조회
    @GetMapping("")
    public ResponseEntity<List<MovieDto>> moviePrint(){
        List<MovieDto> result = movieService.moviePrint();
        return ResponseEntity.ok().body(result);
    }// func end

    // [4] 개별조회
    @GetMapping("/find")
    public ResponseEntity<MovieDto> movieFind(@RequestParam int mno){
        MovieDto result = movieService.movieFind(mno);
        return ResponseEntity.ok().body(result);
    }// func end
}// class end
