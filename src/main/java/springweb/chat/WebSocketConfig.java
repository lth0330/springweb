package springweb.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration  // 빈(객체) (스프링컨테이너)등록, 스프링이 인식할 수 있도록 ,  IOC
@EnableWebSocketMessageBroker   // [2] websocket + stomp 메세지 브로커 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // implements : 인터페이스 구현(재구현) vs extends 클래스 상속(물려받음)
    // 스프링프레임워크 장점 : 인터페이스구조라서 만들어진 기능들을 재정의 가능하다.

    // 오버라이딩(재정의) vs 오버로딩(매개변수에 따라 메소드/생성자 정의)

    // [3] 메세지 브로커 설정
    @Override   // 오버라이딩
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // [4] 구독 주소 설정 : 클라이언트가 설정한 주소를 요청(구독)하면 (서버에게) 메세지를 받을 수 있다.
        // http:localhost:8080/topic/ ~~~
        registry.enableSimpleBroker("/topic");

        // [5] 발행 주소 설정 : 클라이언트가 서버에게 메세지를 보낼 때 사용되는 주소 앞에 붇는 키워드
        //  http:localhost:8080/app/ ~~~
        registry.setApplicationDestinationPrefixes("/app");
    }

    // [6] websocket 접속 주소 설정 : 앤드ㅗ인트 ( 메세지의 종착점 )
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // [7]
        registry.addEndpoint("/ws") // 앤드 포인트 ws:localhost:8080
                //.setAllowedOrigins("http://localhost:5713)    // 특정 도메인만 허용
                .setAllowedOriginPatterns("*");
    }
}
