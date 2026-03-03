package study.day04.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // 컨트롤러 계층
public class TestController {

    @Autowired TestService testService; // DI

    @GetMapping("/test1")
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }

    @GetMapping("/test2")
    public boolean saveMember(){
        boolean result = testService.saveMember();
        return result;
    }
}
