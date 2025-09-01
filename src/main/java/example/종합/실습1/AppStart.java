package example.종합.실습1; // 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppStart {// class start
    public static void main(String[] args) { // main start
        SpringApplication.run(AppStart.class);
    }// main end
}// class end
