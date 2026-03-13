package practice.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.practice7.Dto.CourseDto;
import practice.practice7.Dto.EnrollDto;
import practice.practice7.Dto.StudentDto;
import practice.practice7.service.EnrollService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    // 학생
    @PostMapping("/student")
    public boolean 학생등록(@RequestBody StudentDto studentDto) {
        boolean result = enrollService.학생등록(studentDto);
        return result;
    }

    // 과정
    @PostMapping("/course")
    public boolean 과정등록(@RequestBody CourseDto courseDto){
        boolean result = enrollService.과정등록(courseDto);
        return result;
    }

    // 수강
    @PostMapping("/enroll")
    public boolean 수강등록(@RequestBody EnrollDto enrollDto){
        boolean result = enrollService.수강등록(enrollDto);
        return result;
    }

    // 수강
    @GetMapping("/enroll")
    public EnrollDto 수강조회(@RequestParam int enrollId){
        EnrollDto result = enrollService.수강조회(enrollId);
        return result;
    }
}
