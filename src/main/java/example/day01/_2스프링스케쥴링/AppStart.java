package example.day01._2스프링스케쥴링;// 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케쥴링 사용 활성화
public class AppStart {// class start
    public static void main(String[] args) {// main start
        SpringApplication.run(AppStart.class);
    }// main end
}// class end
