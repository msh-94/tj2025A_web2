package example2.종합.실습2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // [1] 등록
    @PostMapping // localhost:8080/api/movie
    // { "title" : "자바는혁명이다" , "director" : "유재석" , "releaseDate" : "2025-11-04" , "rating" : "4.5" }
    public ResponseEntity<?> save(@RequestBody MovieDto dto){
        return ResponseEntity.ok(movieService.save(dto));
    }// func end

    // [2] 전체조회
    @GetMapping // localhost:8080/api/movie
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }// func end

    // [3] 개별 조회
    @GetMapping("/find") // localhost:8080/api/movie/find?movie_id=
    public ResponseEntity<?> find(@RequestParam int movie_id){
        return ResponseEntity.ok(movieService.find(movie_id));
    }// func end

    // [4] 개별 수정
    @PutMapping // localhost:8080/api/movie
    // { "movie_Id" : "1" , "title" : "스프링은최고다" , "director" : "강호동" , "releaseDate" : "2025-11-05" , "rating" : "5.0" }
    public ResponseEntity<?> update(@RequestBody MovieDto dto){
        return ResponseEntity.ok(movieService.update(dto));
    }// func end

    // [5] 개별 삭제
    @DeleteMapping // localhost:8080/api/movie?movie_id=
    public ResponseEntity<?> delete(@RequestParam int movie_id){
        return ResponseEntity.ok(movieService.delete(movie_id));
    }// func end

}// class end
