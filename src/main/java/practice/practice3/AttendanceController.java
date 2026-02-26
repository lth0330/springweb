package practice.practice3;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {


    @PostMapping
    public boolean method1(@RequestBody AttendanceDto attendanceDto){
        System.out.println("AttendanceController.method1");
        System.out.println("attendanceDto = " + attendanceDto);
        return true;
    }
    @GetMapping
    public List<AttendanceDto> method2(){
        List<AttendanceDto> list = new ArrayList<>();
        list.add( new AttendanceDto(1,"유재석","2026-2-26","출석"));
        list.add( new AttendanceDto(2,"유재석2","2026-2-26","출석"));
        return list;
    }

}
