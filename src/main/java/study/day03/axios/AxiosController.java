package study.day03.axios;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day03/task")
public class AxiosController {

    @GetMapping
    public void method1(){
        System.out.println("AxiosController.method1");
    }
}
