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


    @GetMapping("/create")  // http://localhost:8080/api/jwt/create?data=%EB%B0%94%EB%82%98%EB%82%98
    public ResponseEntity<?> 토큰생성(@RequestParam String data){
        return ResponseEntity.ok(jwtService.토큰생성(data));
    }

    // [2] JWT 토큰 값 추출 == 암호화된 JWT 토큰을 다시 평문으로
    @GetMapping("/read")
    public ResponseEntity<?> 토큰값추출(@RequestParam String 토큰){
        return ResponseEntity.ok(jwtService.토큰값추출(토큰));
    }

}
