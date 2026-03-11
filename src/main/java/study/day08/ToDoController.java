package study.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {


    @Autowired
    private ToDoRepository toDoRepository;

    @PostMapping("/todo")
    public boolean 등록(@RequestBody ToDoEntity toDoEntity){
        toDoRepository.save(toDoEntity);
        return true;
    }

    @GetMapping("/todo")
    public List<ToDoEntity> 조회(){
        return  toDoRepository.findAll();

    }
}
