console.log('chatting.js exe');

// [*] 익명의 이름(비회원제) , Math.floor( Math.random * 끝값 ) + 시작값
const randomId = Math.floor( Math.random() * 1000 ) + 1;
const nickName = `익명${randomId}`; // 익명 {난수} // 회원제 일경우 서버 로그인세션정보

// [*] 방번호( url queryString )
const params = new URL(location.href).searchParams;
const room = params.get('room') || "0"; // url 경로상의 room 번호 가져오기 없으면 0

// [1] 서버 웹 소켓과 연동하는 클라이언트 소켓(객체) 생성
const client = new WebSocket('/chat');

// [2] 서버 웹 소켓과 연동 성공했을때 , 
// event 이란 ? 함수의 매개변수 이면서 *해당 이벤트 정보*를 담고 있는 객체
client.onopen = ( event ) => {
    console.log('=========== 서버 소켓과 연동 성공 ===========');
    // (1) ============ 방번호에 특정한 닉네임 **등록** 메시지 보내기 ============
    let msg = { type : "join" , room : room , nickName : nickName } // JSON 형식으로 문자열 메시지 보내기
    // JSON.stringify() : 객체(JSON)를 형식을 유지하고 문자열 타입으로 변환
    // JSON.parse()     : 문자열 타입을 객체(JSON) 타입으로 변환
    client.send(JSON.stringify(msg));
}
// [3] 서버 웹 소켓과 연동 끊겼을때
client.onclose = ( event ) => {
    console.log('=========== 서버 소켓과 연동 종료 ===========');
}
// [4] 서버 웹 소켓으로부터 메시지를 받았을때
client.onmessage = ( event ) => {
    console.log('=========== 서버 소켓으로부터 메시지를 받았다 ==========='); 
    console.log(event); // 해당 메소드가 왜 실행 되었는지 여러 정보가 들어있는 객체
    console.log(event.data); // 4-1 서버로부터 받은 메시지(data속성) 확인
    // 4-2 받은 메시지를 JSON형식으로 변환
    const message = JSON.parse(event.data);
    // 4-3 받은 메시지의 type을 확인하여 서로 다른 html 만들어주기
    let html = "";
    if(message.type == 'alarm'){
        html += `<div class="alarm">
                    <span> ${message.message} </span>
                </div>`
    }// if end
    // 4-4 구성한 html를 <div class="msgbox">에 추가하기 , 대입 = , 추가 +=
    document.querySelector('.msgbox').innerHTML += html;

}// func end