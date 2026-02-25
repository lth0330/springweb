package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component  // 빈 등록
//@Controller // HTTP 통신 기능 + 빈 등록 포합    = 사용처 : view(화면) 반환
@RestController   // +ResponseBody 포함  =  사용처 : 값(JSON) 반환
@RequestMapping("/day02")//@RequestMapping("/공통 URL") : 해당 컨트롤러내 메소드들이 사용되는 공통 URL을 정의한다.
public class RestController3 {
    // 1.
    @GetMapping("/task6")
    public String method1(){return "서버에게 받은 메세지";}


} // class end
