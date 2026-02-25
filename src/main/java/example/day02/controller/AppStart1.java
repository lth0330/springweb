package example.day02.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan : 스피링이 실행될 때 컨테이너에 등록할 빈(@Component)들을 동일/하위 패키지
// @Component : @Controller @Service @RestController @Repository 등등 몇몇 어노테이션들을 내장됨.
public class AppStart1 {
    public static void main(String[] args) {
        SpringApplication.run(AppStart1.class);
    }
}
