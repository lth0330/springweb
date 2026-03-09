package practice.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.practice7.Dto.StudentDto;
import practice.practice7.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public boolean 학생등록(StudentDto studentDto){
        boolean result = studentService.학생등록(studentDto);
        return result;
    }
}
