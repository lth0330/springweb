package practice.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.practice7.Dto.EnrollDto;
import practice.practice7.service.EnrollService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    @PostMapping("/enroll")
    public boolean 수강등록(@RequestBody EnrollDto enrollDto){
        boolean result = enrollService.수강등록(enrollDto);
        return result;
    }
    /*
    @GetMapping("/enroll")
    public List<EnrollDto> 수강조회(){
        List<EnrollDto> enrollDtoList = enrollService.수강조회();
        return enrollDtoList;
    }*/
}
