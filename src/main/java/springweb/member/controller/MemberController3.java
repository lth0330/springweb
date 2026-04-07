package springweb.member.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService2;
import springweb.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member3")
@CrossOrigin(value = "http://localhost:5173", allowCredentials = "true")
public class MemberController3 {

    private final MemberService memberService;
    private final JWTService2 jwtService; // jwt 기능 객체

    // [2] 로그인 = 세션방식 ---> 토큰방식 변경 + 쿠키
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto,
                                   HttpServletResponse response) { // httpServletResponse 응답객체
        boolean result = memberService.login(loginDto);
        // 1] 만약에 로그인 성공이면
        if (result) {
            // 2] 로그인성공한 정보(아이디) 토큰에 저장
            String token = jwtService.createToken(loginDto.getMid());
            // ======================== 쿠키에 토큰 담아서 응답하기 ========================
            // (1) 쿠키에 토큰 담기 , new Cookie( "속성명" , 값 );
            Cookie cookie = new Cookie("token", token);
            // (2) 쿠키 옵션 *
            cookie.setHttpOnly(true);  // .setHttpOnly( true ) : 쿠키접근 방법 , true이면 js가 접근 못한다.
            cookie.setSecure(false); //.setSecure( true ) : true 이면 https 만 접근 가능
            cookie.setPath("/"); // .setPath( ) : 쿠키 접근하는 경로 , "/" :전체경로
            // cookie.setMaxAge( ); // .setMaxAge( 초 ) : 쿠키 유지시간
            // (3) 쿠키 응답하기 , response.addCookie( 쿠키객체 );
            response.addCookie(cookie);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    // [3] 로그아웃 = 세션방식 ---> 토큰방식 변경 + 쿠키

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        // 1) 매개변수에 HttpServletResponse response
        // 2) 삭제할 쿠키의 동일한 속성명으로 null 값 저장하는 쿠키 생성
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);  // 쿠키의 생명주기를 0으로 설정한다.
        cookie.setPath("/");

        // 3) 쿠키 반환
        response.addCookie(cookie);

        // 4) 값 반환
        return ResponseEntity.ok(true);
    }

    // [4] 마이페이지 = 세션방식 ---> 토큰방식 변경 + 쿠키
    @GetMapping("/my/info")
    public ResponseEntity<?> myInfo(@CookieValue( value = "token", required = false) String token) {
        // @CookiewValue : HTTP 요청의 cookie 정보 매핑
        // @CookieValue( value = "token") String token 매개변수를 받는다.
        // required = false 로 설정하면 매개변수가 필수값이 아닌 상태 (비로그인 추가)

        // 1] @RequestHeader("Authorization") String token 를 매개변수로 받는다.
        // 2] 만약에 헤더가 없거나 토큰이 없으면 비로그인
        if (token == null) {
            return ResponseEntity.ok(false);
        }

        // 4] 토큰에서 값(클레임) 추출
        String mid = jwtService.getClaim(token);
        if (mid == null) return ResponseEntity.ok(false);   // 토큰 문제로 실패

        // 5] 토큰에서 꺼낸 값(mid) 으로 회원정보 요청하기
        return ResponseEntity.ok(memberService.myInfo(mid));
    }
}

