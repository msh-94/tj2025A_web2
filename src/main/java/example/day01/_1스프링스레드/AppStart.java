package example.day01._1스프링스레드; // 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 비동기 사용 활성화
public class AppStart {// class start
    public static void main(String[] args) { // main start
        SpringApplication.run(AppStart.class);
    }// main end
}// class end
