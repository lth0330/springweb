package practice.practice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/practice2/post")
public class PostController {

    @PostMapping("/p1")
    public boolean write(){

        return true;
    }

    @GetMapping("/p2")
    public List<Map<String,String >> view(){

        List<Map<String ,String>> list = new ArrayList<>();
        System.out.println("PostController.view");
        return list;
    }
}
