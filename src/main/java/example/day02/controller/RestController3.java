package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Component  // 빈 등록
//@Controller // HTTP 통신 기능 + 빈 등록 포합    = 사용처 : view(화면) 반환
@RestController   // +ResponseBody 포함  =  사용처 : 값(JSON) 반환
@RequestMapping("/day02")//@RequestMapping("/공통 URL") : 해당 컨트롤러내 메소드들이 사용되는 공통 URL을 정의한다.
public class RestController3 {
    // 1. 클래스가 @RestController 이므로 @ResponseBody을 생략해도 된다.
    @GetMapping("/task6") // * 클래스가 @RequestMapping("/공통 URL")을 가지므로 앞에것을 안적어도 된다.
    public String method1(){return "서버에게 받은 메세지";}

    // 2. http://localhost:8080/day02/task7?name=유재석&age=54
    @GetMapping("/task7") // 쿼리스트링이란? URL(웹주소) 뒤로 ? 작성 후 매개변수명1=값&매개변수명2=값
    public int method2(@RequestParam String name, @RequestParam int age){ // 쿼리스트링매개변수명 == 메소드매개변수명
        //RequestParm 이란? URL(웹주소) 안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 (생략가능)
        System.out.println("RestController3.method2"); // soutm : 메소드명 출력 자동완성
        System.out.println("name = " + name + ", age = " + age);  //soutp : 메소드 매개변수 출력 자동완성
        return 3;
    }
    // 3. http://localhost:8080/day02/task8?name=유재석&age=56
    @GetMapping("/task8")
    // 만약에 쿼리스트링의 매개변수명과 자바의 매개변수명이 다르면 @RequesParam(name = "쿼리스트링매개변수명")
    public int method3(@RequestParam String name, @RequestParam(name ="age") int 나이){
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 8;
    }

} // class end
