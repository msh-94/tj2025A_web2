package example.day05._2웹크롤링2; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task/day05")
@RequiredArgsConstructor // final 멤버변수의 생성자를 자동
public class CrawlingController { // class start
    // @Autowired : DI 스프링 컨테이너에서 빈(객체) 꺼내기
    private final CrawlingService crawlingService;
    // 1.
    @GetMapping("/crawling1")
    public Map<String,String> task1(){
        return crawlingService.task1();
    }// func end

    // 2.
    @GetMapping("/crawling2")
    public List<String> task2(){
        return crawlingService.task2();
    }// func end
} // class end
