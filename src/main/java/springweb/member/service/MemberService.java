package springweb.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springweb.member.dto.MemberDto;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    // [*] 비크립트(암호화) 객체 생성
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // [1] 회원가입
    public boolean signup(MemberDto memberDto ){
        MemberEntity saveEntity = memberDto.toEntity(); // 1] 저장할 dto --> entity 변환
        // ******* 최종 저장 하기 전에 입력받은 비밀번호를 암호화 ********** //
        String pwd = passwordEncoder.encode( saveEntity.getMpwd() ); // - 입력받은 패스워드 암호화
        saveEntity.setMpwd( pwd ); // - 암호화된 패스워드 대입
        MemberEntity savedEntity = memberRepository.save( saveEntity );// 2] jpa의 save 메소드
        if( savedEntity.getMno() > 0 ){ return true; }// 3] 확인
        return false;
    }

    // [2] 로그인
    public boolean login(MemberDto loginDto){
        // 1] JPA으로 아이디로 엔티티찾기, SQL로 아이디/비밀번호 일치 여부로 로그인 판단 불가능 ,

        Optional<MemberEntity> optionalMember =
                memberRepository.findByMid(loginDto.getMid());

        // 2] 만약에 조회된 앤티티가 존재하면
        if (optionalMember.isPresent()){
            // 앤티티 꺼내기
            MemberEntity memberEntity = optionalMember.get();
            // 비크립트 암호화로 평문과 암호화문 비교
            // passwordEncoder.matches(평문, 암호화);
            boolean result = passwordEncoder.matches(loginDto.getMpwd(),memberEntity.getMpwd());
            if (result){return true;}
            else {return false;}

        }
    return false;
    }

    // [4] 마이페이지
    public MemberDto myInfo(String loginMid){
        // 1) 로그인된 mid를 받아서 리포지토리에서 찾는다. , 아까 해서 찾으면 됨
        Optional<MemberEntity> entityOptional
                = memberRepository.findByMid(loginMid);
        // 2) 만약 앤티티가 존재하면 앤티티를 꺼내서 dto 반환하여 반환한다.
        if (entityOptional.isPresent()){ return entityOptional.get().toDto();}
        return null;
    }

} // class end
/*

    암호화
        1.정의 : 자료를 보호 하기 위해 사람이 이해하기 어려운 테이터로 변환
        2.목적 : 자료보호, 신뢰성, 무결성 유지
        3.사용처 : 비밀번호, 금융, HTTPS 등등
        4.용어 :
            1) 평문 : 원래의 자료
            2) 암호문 : 암호화된 자료
            3) 암호화 : 평문자료를 암호문으로 변환하는 과정
            4) 복호화 : 암호문 자료를 평문으로 변환하는 과정
            5) 단방향 암호화 : 평문을 암호문으로 변환하고 다시 평문으로 변환 불가능 < 암호화 >
            6) 양방향 암호화 : 평문을 암호문으로 변환하고 다시 평문으로 변환 가능 < 암호화/복호화 >
            7) 해시 함수 : 자료를 고정된 길이로 변환하는 함수
                * 서로 다른 자료들을 *동일한 길이* 로 변화하는 함수
                * 임의의 계산식으로 변환하는 과정이므로 다시 되돌리기 불가능하다.
                - 자바 : .hashCode( ) , Object클래스의 메소드로 객체주소값을 해시코드(일정한길이의값)로 반환
                - '사과' -----> A1B2C3
                - '사과' -----> A1B2C3    * 같은 자료는 같은 해시값이 나올 수 있다.
                - '바나나' -----> X1C2V3   * 단 서로 다른 자료도 일정한 길이로 변환한다.
                - '파인애플' -----> T1Y2U3
            8) 솔트 : 암호화할때 사용되는 랜덤값 ( 동일한 계산식(알고리즘/해시) 의 서로 다른 결과값 )
                - '사과' --> 솔트추가 --> A1B2C5
        5. 종류
            1) 비밀번호     : Bcrypt(비크립트) , 해시함수 , 단방향/복호화없음
            2) 전자서명/파일 : SHA-256 , 해시함수 , 단방향/복호화없음 , sha-비트수
                - bit : 0또는1 , 101 = 3bit
            3) 웹통신      : HTTPS( TLS/SSL ) , HTTP(암호화안된상태) VS HTTPS(암호화된상태)

        6. 비크립트
            1) 정의 : 해시 함수를 이용하여 주로 비밀번호를 암호화할때 사용된다.
            2) 특징
                - 솔트(salt) : 같은 비밀번호라도 램덤(salt)값으로 서로 다른 암호화된 결과를 만든다.
                - 반복연산적용 : 계산식을 여러번 하여 검증 속도를 늦춤
                - 원본 복구 불가능 : 단방향 암호화문으로 비밀번호찾기 대신에 임시비밀번호 부여/수정
            3) 형태
                $10$vypKvzfa914zdPj/C2DCgelPChkfgosaHX55NNdX1FvQapSC84DUW
                - 2a : 비크립트 버전
                - $10 : 반복연산수, 제곱근
                - slat(22글자), 그 뒤로는 해시값
                * 평문과 암호문 비교할때는 암호문의 연산수와 slat와 해시값으로 평문을 암호화해서 비교한다.
            4) 설치 :
                1: SPRING 시큐리티 포함 : implementation 'org.springframework.boot:spring-boot-starter-security'
                *2: SPRING 시큐리티내 비크립트만 : implementation 'org.springframework.security:spring-security-crypto:6.4.4'
            5) 사용법
                BCryptPasswordEncoder 암호객체 = new BCryptPasswordEncoder();
                - String 암호화된값 = 암호객체.encode( 암호화할자료 )

*/
