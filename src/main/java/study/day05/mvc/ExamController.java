package study.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/day05/exam")
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;


    // R : 조회 select
    @GetMapping
    public List<ExamDto> 전체조회(){
        List <ExamDto> result = examService.전체조회();
        return result;
    }
    // W : 쓰기 insert

    // D : 삭제 delete

    // U : 수정 update

}
