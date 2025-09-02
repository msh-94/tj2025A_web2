console.log('실습2.js exe');

const client = new WebSocket("/alarm");

client.onopen = ( event ) => {
    client.send("익명의 유저가 접속했습니다.");
}


client.onmessage = ( event ) => {
    alert(event.data);
}