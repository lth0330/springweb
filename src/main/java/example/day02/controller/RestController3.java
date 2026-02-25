package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

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
        return 7;
    }

    // 3. http://localhost:8080/day02/task8?name=유재석&age=56
    @GetMapping("/task8")
    // 만약에 쿼리스트링의 매개변수명과 자바의 매개변수명이 다르면 @RequesParam(name = "쿼리스트링매개변수명")
    // 만약에 쿼리스트링의 매개변수명을 필수로 하지 않을경우 @RequestParam(require = false), 기본값 true
    public int method3(@RequestParam(required = false) String name, @RequestParam(name ="age") int 나이){
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 8;
    }

    // 4. http://localhost:8080/day02/task9?name=유재석&age=56
    @DeleteMapping("/task9") // GET/DELETE 메소드는 구조와 사용법이 동일하다.     // POST와 PUT 메소들끼리 동일
    public int method4(String name, @RequestParam(defaultValue = "19")int age){
        // 만약에 @RequestParm을 생략해도 매개변수 매핑(연결)이 가능하다.
        // 만약에 쿼리스트링의 존재하지 않을때 기본값으로 설정하기 위해서 @RequestParam(defaultValue ="초기값")
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;
    }

    // 5. http://localhost:8080/day02/task10?name=유재석&age=10
    @DeleteMapping("/task10") // 여러개 매개변수를 하나의 Map 타입으로 받을 수 있다.
    public int method5(@RequestParam Map<String, Object> map){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map);
        return 10;
    }

    // 6. http://localhost:8080/day02/task11?name=유재석&age=50
    @PostMapping("/task11")
     public int method6(@ModelAttribute ExamDto examDto){
        System.out.println("RestController3.method6");
        System.out.println("examDto = " + examDto);
        return 11;
    }
    // 즉] URL?매개변수=값 방식인 쿼리스트링은 URL상 매개변수가 노출된다.
    // GET/DELETE -> 쿼리스트링 -> @RequesParam/@ModelAttribute
    // POST/PUT -> 쿼리스트링/BODY본문 -> @RequesBody
    // 즉2] URL 상의 매개변수 노출을 가리기 위한 BODY(본문)을 사용하자.
    //      노출이 되면 안되는 개인정보/패스워드/민감한 정보들은 POST/PUT BODY(본문)을 사용
    // 에시] 편지의 편지봉투 = 쿼리스트링, 편지안의 안내물 = BODY

    // 7. http://localhost:8080/day02/task12
    // BODY : {"name":"유재석", "age" : 50 }
    // HTML --> JS -- > JAVA(controller -> dao)
    @PostMapping("/task12")
    public int method12(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method12");
        System.out.println("examDto = " + examDto);
        return 12;
    }

    // 8.
    @PutMapping("/task13")
    public int method13(@RequestBody Map<String ,Object> map){
        System.out.println("map = " + map);
        System.out.println("RestController3.method13");
        return 13;
    }

} // class end
