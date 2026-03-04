package study.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // C : 쓰기 insert
    @PostMapping
    public boolean 저장(@RequestBody ExamDto examDto){
        boolean result = examService.저장(examDto);
        return result;
    }

    // D : 삭제 delete
    @DeleteMapping
    public boolean 삭제(@RequestParam  int eno){
        boolean result = examService.삭제(eno);
        return result;
    }
    // U : 수정 update
    @PutMapping
    public boolean 수정(@RequestBody ExamDto examDto){
        boolean result = examService.수정(examDto);
        return  result;
    }

}
