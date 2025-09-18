import { useState } from "react"
import './Task.css';
let num = 3;
export default function Task4( props ){
    // 1. useState : 상태(변수값) 관리(변수값에 따른 재렌더링) 훅
    const [ name , setName ] = useState('');
    const [ phone , setPhone ] = useState('');
    const [ age , setAge ] = useState('');
    const list = [{ num : 0 , name : '신동엽' , phone : '010-7894-7894' , age : 50 } ,
                    { num : 1,  name : '강호동' , phone : '010-4321-4321' , age : 40 } ,
                    { num : 2 , name : '유재석' , phone : '010-1234-1234' , age : 30 }]
    const [ array , setArray ] = useState(list);
    // 2. '등록' 버튼 클릭 했을때 함수
    const listAdd = () => {
        const obj = { num : num++ , name , phone , age }
        array.push(obj);
        setArray([...array]);  // 주의할점 : 객체/배열은 ...스프레드 연산자 이용한 복사 = 주소값 변경  
        setName('');
        setPhone('');
        setAge('');    
    }
    // 3. '삭제' 버튼 클릭 했을때 함수 , 무엇을 삭제할지 식별번호/키 필요
    const listDel = (num) => {
        setArray(array.filter((info) => info.num != num)); // react 권장 방식
        // for(let i = 0; i < array.length; i++ ){
        //     if( array[i].num == num ){
        //         array.splice( i , 1 );
        //         setArray([...array]);
        //     }// if end
        // }// for end
    }
    // ------------- jsx에서 { } 중괄호는 js표현식의 시작과 끝
    // ------------- [1] 1. onClick={ 함수명 } 또는 
    //                   2. onClick={ () => { 함수명(매개변수) } }    3. 주의할점 : onClick={ 함수명() } 함수명 뒤에 소괄호 x
    // ------------- [2] 리스트 출력시 forEach 대신에 ** map ** 사용한다
    return (
        <>
        <div className="wrap">
            <h2 className='titleName'> 전화번호부 </h2>
            <input placeholder="성명" value={name} onChange={ (e) => { setName( e.target.value ); } }/> 
            <input placeholder="연락처 (예:010-1234-5678)" value={phone} onChange={ (e) => { setPhone( e.target.value ); } }/>
            <input placeholder="나이" value={age} onChange={ (e) => { setAge( parseInt(e.target.value) ); } }/>
            <button className='addBtn' onClick={ listAdd }> 등록 </button>
            <ul className="listBox">
                { array.map( ( info ) => {
                    return  <li key={info.num}><div><span>성명</span>: {info.name} <span>연락처</span>: {info.phone} <span>나이</span>: {info.age}</div> 
                    <div><button className="delBtn" onClick={ ()=>{ listDel(info.num); } }> 삭제 </button></div></li> 
                }) }
                
            </ul>
            <div className="countBox">총 {array.length}명</div>
        </div>        
        </>
    )
}// func end

