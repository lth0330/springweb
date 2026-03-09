package practice.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.practice7.Dto.CourseDto;
import practice.practice7.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public boolean 과정등록(@RequestBody CourseDto courseDto){
        boolean result = courseService.과정등록(courseDto);
        return result;
    }
}
