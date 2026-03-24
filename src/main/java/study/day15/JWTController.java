package study.day15;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jwt")
@RequiredArgsConstructor
public class JWTController {

    private final JWTService jwtService;

    @GetMapping("/create")
    public ResponseEntity<?> 토큰생성(@RequestParam String data){
        return ResponseEntity.ok(jwtService.토큰생성(data));
    }

}
