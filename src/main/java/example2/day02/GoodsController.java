package example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    // [1] 등록
    @PostMapping // localhost:8080/api/goods
    // { "gname" : "아메리카노" , "gprice" : "1500" , "gdesc" : "콜롬비아원두" }
    public ResponseEntity<?> save(@RequestBody GoodsDto dto){
        GoodsDto goodsDto = goodsService.save(dto);
        return ResponseEntity.ok(goodsDto);
    }// func end

    // [2] 전체조회
    @GetMapping // localhost:8080/api/goods
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(goodsService.findAll());
    }// func end

    // [3] 개별조회
    @GetMapping("/find") // localhost:8080/api/goods/find?gno=
    public ResponseEntity<?> find(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.find(gno));
    }// func end

    // [4] 개별삭제
    @DeleteMapping() // localhost:8080/api/goods?gno=
    public ResponseEntity<?> delete(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.delete(gno));
    }// func end

    // [5] 개별수정
    @PutMapping() // localhost:8080/api/goods
    // { "gno" : "2" , "gname" : "헛개리카노" , "gprice" : "2000" , "gdesc" : "헛개수" }
    public ResponseEntity<?> update(@RequestBody GoodsDto dto){
        return ResponseEntity.ok(goodsService.update(dto));
    }// func end

} // class end
