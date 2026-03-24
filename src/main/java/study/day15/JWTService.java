package study.day15;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class JWTService {

    // [1]
    // * 내가 만든 임의의 값으로 토큰에 사용되는 암호화 계산식의 비밀번호
    private final String 비밀번호 = "123456789123456789123456789123456789";

    // * 내가 만든 임의의 값(비밀번호) 해시값으로 반환
    private final Key 비밀키 = Keys.hmacShaKeyFor(비밀번호.getBytes());

    // jwt 토큰 생성
    public String 토큰생성(String data) {
        String token = Jwts.builder() // 토튼 생성 시작
                //.claim("key",value) 토큰에 저장할 자료를 key와 value 대입하낟
                .claim("data", data)
                .setIssuedAt(new Date())    // 토튼 발급날짜/시간 , new Date() : 시스템날짜/시간반환
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 15))    // 토튼 유지/ 유효 시간, 초단위
                .signWith(비밀키, SignatureAlgorithm.HS256)//.signWith("비밀키",암호화알고리즘), 최종 토큰 암호화는 HS256 알고리즘 적용
                .compact(); // [e] 토큰 최종 문자열로 반환
        return token;
    }

    // [2] 값 추출
    public String 토큰값추출(String 토큰) {
        try {


            Claims claims = Jwts.parser()   //  파싱 / 가져온다 뜻
                    .setSigningKey(비밀키) // 서명 검증에 필요한 비밀키 대입
                    .build()              // 비밀키 확인
                    .parseClaimsJws(토큰)  // 검증할 토큰 대입한다.
                    .getBody();           // 검증 성공시 클레임(내용물)을 가져온다
            return (String) claims.get("data");    // 저장된 값은 무조건 Object 타입이다.
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
/*
    JWT (json web token)
        1. 정의 : JSON 혀식의 데이터를 저장하기 사용하기 위한 토큰 기반의 인증 형식
        2. 목적 : 웹/앱 에서 인증과 권한부여/화긴 사용(클라이언트) vs 세션(서버)


    사용법
        1) 설치
                implementation 'io.jsonwebtoken:jjwt-api:0.12.6'    // JWT
                runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.6'  // JWT
                runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.6' // JWT
 */
