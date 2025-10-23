package example.day17;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController { // class start

    // [*] 간단한 텍스트를 레디스에 접근하는 객체
    private final RedisTemplate redisTemplate; // 템플릿이란? 미리 만들어진 틀/형식
    private final RedisTemplate<String,Object> template;

    // [1] 간단한 텍스트를 레디스 서버에 저장하고 호출하기 ( 컨트롤러에서 호출 x )
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        System.out.println("RedisController.test");
        // [저장] 레디스템플릿객체명.opsForValue().set( key , value ); , key 값은 중복이 안되므로 중복이면 덮여쓰기 적용
        // { "유재석" : "90"  } , { "강호동" : "80" }
        redisTemplate.opsForValue().set("유재석" , "90" ); // 임의 데이터1
        redisTemplate.opsForValue().set( "강호동" , "80" ); // 임의 데이터2
        redisTemplate.opsForValue().set( "유재석" , "100" ); // key는 중복을 허용하지 않고 , value 중복 허용
        // [ 모든 키 호출] 레디스템플릿객체명.keys("*")         : 레디스에 저장된 모든 키 반환
        // [ 특정한 키의 값 호출] 레디스템플릿객체명.opsForValue().get( key );
        Set< String > keys = redisTemplate.keys("*");
        //  List vs Map vs Set 컬렉션 프레임워크이란?차이?
        List< Object > result = new ArrayList<>(); // 임의의 리스트
        for( String key : keys ){
            result.add( redisTemplate.opsForValue().get( key ) );
        }
        return ResponseEntity.ok( result );
    } // method end

    // day13/day06 CRUD 를 데이터베이스 없이 레디스로 실습
    // 1. 등록
    @PostMapping("")
    private ResponseEntity<?> save(@RequestBody StudentDto dto){
        System.out.println("dto = " + dto);
        // 0. 중복없는 key 구상
        String key = "student:"+dto.getSno(); // sno를 key로 조합하여 , 예] student:1 , student:2
        // 1. 레디스에 전달받은 값 저장한다
        // 예상 : { "student:1 : {"sno" : 1 , "name" : "강호동", "math" : "80" , "kor" : "100" } }
        template.opsForValue().set(key,dto);
        return ResponseEntity.ok("[저장성공]");
    }// func end

    // 2. 전체조회
    @GetMapping("")
    private ResponseEntity<?> findAll(){
        System.out.println("RedisController.findAll");
        // 0. 조회할 key를 모두 가져온다 , * : 레디스내 모든 키 , xxxx:* : xxxx:동일하고 * 자리는 임의의 문자 대응
        Set<String> keys = template.keys("student:*");
        // 1. 반복문 이용한 value 꺼내서 리스트에 담기
        List<Object> result = new ArrayList<>();
        for (String key : keys){ result.add(template.opsForValue().get(key)); }// for end
        return ResponseEntity.ok("[조회성공]");
    }// func end

    // 3. 개별조회
    @GetMapping("/find")
    public ResponseEntity<?> find( @RequestParam int sno){
        // 1. 조회할 key 구성
        String key = "student:"+sno;
        // 2. 특정한 key의 value 호출
        Object result = template.opsForValue().get(key);
        return ResponseEntity.ok(result);
    }// func end

    // 4. 개별삭제
    @DeleteMapping("")
    public ResponseEntity<?> delete( @RequestParam int sno){
        String key = "student:"+sno;
        Object result = template.delete(key);
        return ResponseEntity.ok(result);
    }// func end

    // 5. 개별수정
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody StudentDto dto){
        String key = "student:"+dto.getSno();
        template.opsForValue().set(key,dto);
        return ResponseEntity.ok(true);
    }// func end

    // * 인증코드 발급 해서 레디스 유효기간 정하기
    // TTL : 레디스에 저장된 엔트리(key-value)를 특정한 기간(시간)이 되면 자동 삭제
    @GetMapping("/auth/send")
    public ResponseEntity<?> authSend( @RequestParam String phone){
        // 1. key 구상 , "auth:고객전화번호"
        String key = "auth:"+phone; // 핸드폰 번호마다 한개씩 인증코드
        // 난수 6자리
        String code = String.format("%06d",new Random().nextInt(999999));
        // 2. 레디스에 인증코드 저장하기
        template.opsForValue().set( key , code , Duration.ofSeconds(10));
        // API 이용하여 고객전화번호에게 인증코드 전송
        return ResponseEntity.ok("인증코드 발급 완료"+code);
    }// func end

    @GetMapping("/auth/confirm")
    public ResponseEntity<?> authConfirm( @RequestParam String phone , @RequestParam String code){
        String key = "auth:"+phone;
        Object savedCode = template.opsForValue().get(key);
        if (savedCode == null ){ return ResponseEntity.ok("인증 실패 : 인증 만료 또는 코드 불일치"); }
        else if (savedCode.equals(code)) { return ResponseEntity.ok("[인증성공]"); }
        else { return ResponseEntity.ok("[인증실패]"); }
    }// func end

}// class end
