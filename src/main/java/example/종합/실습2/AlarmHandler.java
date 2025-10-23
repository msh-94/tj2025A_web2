package example.종합.실습2;// 패키지명

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component
public class AlarmHandler extends TextWebSocketHandler { // class start

    // [*] 접속명단
    private static final List<WebSocketSession> list = new Vector<>();
    TextMessage message;

    // [1] 접속
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속");
        list.add(session);
    }

    // [2] 접속종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("접속 종료");
        list.remove(session);
        for (WebSocketSession web : list){
            web.sendMessage(new TextMessage("익명의 유저가 퇴장했습니다."));
        }
    }

    // [3] 메시지
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("메시지 도착");
        for (WebSocketSession web : list){
            web.sendMessage(message);
        }
    }
}// class end
