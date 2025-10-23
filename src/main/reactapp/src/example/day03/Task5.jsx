// TASK5 : 기존 TASK4.jsx 이어 useEffect/axios를 활용해서 spring+mybatis 서버 와 통신하여 TASK5 완성(등록/전체조회/삭제)하시오.
import { useEffect, useState } from "react"
import axios from "axios";
export default function Task5( props ){
    // 1. useState : 상태(변수값) 관리(변수값에 따른 재렌더링) 훅
    const [ tname , setTname ] = useState('');
    const [ tphone , setTphone ] = useState('');
    const [ tage , setTage ] = useState('');
    const [ array , setArray ] = useState([]);
    // 2. '등록' 버튼 클릭 했을때 함수
    const listAdd = async () => {
        const obj = { tname , tphone , tage }
        const response = await axios.post("http://localhost:8080/task5" , obj);
        if(response.status == 200){
            setTname('');
            setTphone('');
            setTage('');    
            taskPrint();
        }// if end
    }// func end
    // [*] 전체조회
    const taskPrint = async () => {
        const response = await axios.get("http://localhost:8080/task5");
        setArray(response.data);
    }// func end
    useEffect( () => { taskPrint() } , [] );
    // 3. '삭제' 버튼 클릭 했을때 함수 , 무엇을 삭제할지 식별번호/키 필요
    const listDel = async (tno) => {
        const response = await axios.delete(`http://localhost:8080/task5?tno=${tno}`);
        if(response.status == 200){
            setArray(array.filter((info) => info.tno != tno)); // react 권장 방식
            // for(let i = 0; i < array.length; i++ ){
            //     if( array[i].num == num ){
            //         array.splice( i , 1 );
            //         setArray([...array]);
            //     }// if end
            // }// for end
        }// if end
    }// func end
    // ------------- jsx에서 { } 중괄호는 js표현식의 시작과 끝
    // ------------- [1] 1. onClick={ 함수명 } 또는 
    //                   2. onClick={ () => { 함수명(매개변수) } }    3. 주의할점 : onClick={ 함수명() } 함수명 뒤에 소괄호 x
    // ------------- [2] 리스트 출력시 forEach 대신에 ** map ** 사용한다
    return (
        <>
        <div className="wrap">
            <h2 className='titleName'> 전화번호부 </h2>
            <input placeholder="성명" value={tname} onChange={ (e) => { setTname( e.target.value ); } }/> 
            <input placeholder="연락처 (예:010-1234-5678)" value={tphone} onChange={ (e) => { setTphone( e.target.value ); } }/>
            <input placeholder="나이" value={tage} onChange={ (e) => { setTage( parseInt(e.target.value) ); } }/>
            <button className='addBtn' onClick={ listAdd }> 등록 </button>
            <ul className="listBox">
                { array.map( ( info ) => {
                    return  <li key={info.tno}><div><span>성명</span>: {info.tname} <span>연락처</span>: {info.tphone} <span>나이</span>: {info.tage}</div> 
                    <div><button className="delBtn" onClick={ ()=>{ listDel(info.tno); } }> 삭제 </button></div></li> 
                }) }
                
            </ul>
            <div className="countBox">총 {array.length}명</div>
        </div>        
        </>
    )
}// func end
