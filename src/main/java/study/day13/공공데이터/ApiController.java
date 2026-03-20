package study.day13.공공데이터;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;


    // [1]
    @GetMapping("/test1")
    public ResponseEntity<?> test1(){
        return ResponseEntity.ok(apiService.test1());
    }
}
