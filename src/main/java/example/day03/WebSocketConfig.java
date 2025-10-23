package example.day03;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
// *********************** 서버 웹소켓 주소 매핑 설정 클래스 **************************** //
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {// class start
    // [*]
    @Autowired private ChatSocketHandler chatSocketHandler;

    // 주소정의
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatSocketHandler , "/chat");
    }
}// class end
