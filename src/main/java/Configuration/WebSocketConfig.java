package Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration // Spring Bean 구성 클래스임을 나타냄
@EnableWebSocketMessageBroker // WebSocket 및 메시지 브로커를 활성화하도록 지시함, 웹 소켓 메시징을 사용할 수 있도록 설정함.

// WebSocketMessageBrokerConfigurer
// WebSocket 메시지 브로커에 대한 구성을 할 수 있으며, 메시지 라우팅, 인터셉터 설정, 보안 구성 등을 수행할 수 있다.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // stomp 접속 주소 ---> /ws-stomp
        // registerStompEndpoints 메소드: WebSocket 클라이언트가 서버에 연결할 때 사용할 엔드포인트를 설정
        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
        registry.addEndpoint("/ws-stomp") // 연결 될 엔드포인트
                .withSockJS(); // SockJS 연결
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        // 메시지를 구독하는 요청 url ---> 메세지 받을 때
        registry.enableSimpleBroker("/sub");

        // 메시지를 발행하는 요청 url ---> 메세지 보낼 때
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
