package study.day13.공공데이터;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiService {

    // 공공데이터 인증 키 [2]
    String serviceKey = "7540ef37d4d62e8aa1ccaf9c61bc9095638232be0930450a4a0d128c78e9e7d6";

    // 국립중앙의료원_전국 약국 정보 조회 서비스
    // https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=8ed8cb9ff03853245e520f6139a3a496d6c5685e3955d299485d3c9b5bab4555&pageNo=1&numOfRows=10

    // [2] 인천광역시 부평구_맛있는 집(맛집) 현황 JSON
    // https://api.odcloud.kr/api/15103411/v1/uddi:b7c1c017-1d8d-4b19-8bec-c91a13927ea2?page=1&perPage=10&serviceKey=7540ef37d4d62e8aa1ccaf9c61bc9095638232be0930450a4a0d128c78e9e7d6

    private final WebClient webClient = WebClient.builder().build();

    public Map<String ,Object> test1(){
        String uri="https://api.odcloud.kr/api/15103411/v1/uddi:b7c1c017-1d8d-4b19-8bec-c91a13927ea2";
        uri +="?serviceKey="+serviceKey; // 함수 밖에 있는 서비스키 대입
        uri +="&pageNo=1" ;  // 요청 매개변수1, 페이지변호
        uri += "&perPage=67" ;   // 요청 매개변수2, 페이지당 보여줄 자료 개수,
        return webClient.get()
                .uri(uri)   // 요청한 api 주소 넣어준다, URL과 매개변수포함 차이
                .retrieve()    // 반환/통신 결과 수신
                .bodyToMono(Map.class)  // 반환 값을 자바 타임으로 변환  , 즉] 반환타입이 JSON이면 MAP받는다.
                .block();   // 동기( 처리가 끝날때 까지 대기상태) 방식으로 결과 반환


    }



 /*
    API : 데이터 주고받고 기능을 공유할 수 있는 규칙/ 프로토콜(HTTP)
    REST API : HTTP 기반의 API
    종류
        1. 개발 : SPRING CONTROLLER
        2. 활용 : 1) 공공데이터포털
                 2) LLM(AI모델) API
                 3) 사기업
                    카카오(지도, 로그인)
                    네이버(로그인,데이터랩 등)
                    구글(자동입력방지/갭차)
                    번역(DeepL, 파파고 등)
                    결제 ( 테스틔아임포트 / 카카오페이)
                    등등
          반환타입 : JSON / XML
  */
}