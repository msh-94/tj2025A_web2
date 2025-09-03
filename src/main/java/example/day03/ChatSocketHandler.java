package example.day03;// 패키지명

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;

// *********************** 서버소켓 역할 **************************** //
@Component
public class ChatSocketHandler extends TextWebSocketHandler {// class start

    // * 접속된 클라이언트 소켓들을 서버가 가지고 있을 예정
    private static final Map<String,List<WebSocketSession>> 접속명단 = new Hashtable<>();
    // { 0 : ["유재석" , "강호동"] , 1 : ["서장훈" , "김희철"] }
    // key : 방번호 , value : 해당 key(방)의 접속된 클라이언트들

    // [*] JSON 타입을 자바 타입으로 *변환* 해주는 라이브러리 객체 , ObjectMapper
    // 주요메소드
    // 1. objectMapper.readValue( json문자열 , Map.class ) : 문자열(json) --> MAP 객체
    // 2. objectMapper.writeValueAsString( map객체 ) : MAP 객체 --> 문자열(json)
    private final ObjectMapper objectMapper = new ObjectMapper();


    // [1] 클라이언트 소켓 과 서버소켓이 연동 되었을때 이벤트
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("=================== *클라이언트 소켓*이 들어 왔다. ===================");
    }// func end

    // [2] 클라이언트 소켓 과 서버소켓이 연동 끊겼을때 이벤트
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("=================== *클라이언트 소켓*이 나갔다. ===================");
        // 2-1 : 접속이 끊긴 세션(클라이언트소켓) 정보를 확인한다
        String room = (String) session.getAttributes().get("room"); // Object
        String nickName = (String) session.getAttributes().get("nickName");
        // 2-2 : 만약에 방과 닉네임이 일치한 데이터가 접속명단에 존재하면 세션제거
        if (room != null && nickName != null){
            List<WebSocketSession> list = 접속명단.get(room); // 해당 방의 key(방번호) 접속(목록) 꺼내기
            list.remove(session);
            // 2-3 : 세션이 퇴장했을때 알림 메시지 보내기
            alarmMessage(room,nickName+"이 퇴장 했습니다.");
        }// if end
    }// func end

    // [3] 클라이언트 소켓 으로 부터 메시지를 받았을때 이벤트
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("=================== *클라이언트 소켓*으로부터 메시지 받았다. ===================");
        // 3-1 : 클라이언트가 보낸 메시지
        System.out.println(message.getPayload());
        // 3-2 : JSON형식은 자바기준으로 모르기 때문에 JSON 형식을 MAP 타입으로 변환
        // * Restful API 인 @ResponseBody @RequestBody 는 자동으로 JSON <----> MAP 변환 제공 , 웹소켓은 안됨
        Map<String,String> msg = objectMapper.readValue(message.getPayload(),Map.class);
        // 3-3 : 만약에 메시지 타입이 'join' 이면
        if (msg.get("type").equals("join")){
            String room = msg.get("room"); // 방번호
            String nickName = msg.get("nickName"); // 접속자
            // 3-4 현재 메시지를 보내온 클라이언트소켓(세션)에 부가정보(방번호 와 접속자명)추가 , 로그인 세션 비슷
            session.getAttributes().put("room",room);       // 브라우저세션 vs HTTP 세션 vs 웹소켓 세션
            session.getAttributes().put("nickName",nickName);
            // 3-5 접속명단에 등록하기
            if (접속명단.containsKey(room)){ // 만약에 등록할 방번호가 존재하면
                접속명단.get(room).add(session); // 해당하는 방번호에 클라이언트소켓 (세션) 추가
            }else{// 존재하지않으면
                List<WebSocketSession> list = new Vector<>();
                list.add(session); // 새로운 목록에 세션 추가
                접속명단.put(room,list);
            }// if end
            // 3-6 접속한 닉네임을 [4]알림메시지 보내기
            alarmMessage(room,nickName+"이 입장 했습니다.");
        }// if end
        // 3-7 : 만약에 메시지에서 타입(type) 이 'msg' 이면
        else if (msg.get("type").equals("msg")) {
            // 3-8 : 메시지를 보낸 세션의 방번호 확인
            String room = (String) session.getAttributes().get("room");
            // 3-9 : 메시지를 보낸 세션의 같은방 번호의 목록들에게 메시지 보내기
            for (WebSocketSession client : 접속명단.get(room)){
                client.sendMessage(message);
            }// for end
        }// if end
        System.out.println(접속명단);
    }// func end

    // [4] 개발자(우리)가 만든 서비스 *추가* 알림 메소드 , 접속[3-6]/퇴장[2-3] 했을때 실행
    public void alarmMessage( String room , String message) throws Exception{
        // String room : 몇번방에? , String message : 메시지내용?
        // throws : 예외처리 던지기 , 해당 메소드에서 모든 예외/오류를 해당 메소드를 호출한곳으로 반환
        // 4-1 : 보내고자 하는 정보를 Map 타입으로 구성
        Map<String,String> msg = new HashMap<>();
        msg.put("type","alarm");
        msg.put("message",message);
        // 4-2 : Map 타입을 JSON 형식의 문자열타입 으로 변환 , objectMapper
        String sendMsg = objectMapper.writeValueAsString(msg);
        // 4-3 : 현재 같은방에 위차한 모든 세션들에게 '알람' 메시지 보내기
        for (WebSocketSession session : 접속명단.get(room)){
            session.sendMessage(new TextMessage(sendMsg));
        }// for end
    }// func end

}// class end
