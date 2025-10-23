import { useEffect, useState } from "react";
import axios from "axios";

// ====== 스프링 서버내 day07(boardservice13) ====== // 
export default function Component10( props ){
    const [ bcontent , setBcontent ] = useState('');
    const [ bwriter , setBwriter ] = useState('');
    const [ list , setList ] = useState( [ ] );

    // [1] 등록
    const boardWrtie = async () => {
        const obj = { bcontent , bwriter }
        const response = await axios.post( "http://localhost:8080/board" , obj );
        console.log( response );
        boardPrint();
        if(response.status == 200 ){
            alert('등록 성공');
            setBcontent('');
            setBwriter('');
        }else{
            alert('등록 실패');
        } 
    }// func end

    // [2] 전체조회
    const boardPrint = async () => {
        const response = await axios.get( "http://localhost:8080/board" );
        console.log( response );
        setList(response.data);
    }// func end

    // [3] useEffect 
    useEffect( () => { boardPrint() } , [] );

    // [4] 수정
    const onUpdate = async ( bcontent , bno ) => { // 페이지 전환 필요
        const obj = { bcontent , bno }
        const response = await axios.put( "http://localhost:8080/board" , obj );
        console.log( response );
        if(response.status == 200){
            alert('수정 성공');
            boardPrint();
        }else{
            alert('수정 실패');
        }// if end
    }// func end

    // [5] 삭제
    const onDelete = async (bno) => {
        const response = await axios.delete( "http://localhost:8080/board?bno="+bno);
        console.log( response );
        if(response.status == 200){
            setList(list.filter( (b) => b.bno != bno ) );
            // or boardPrint(); 
            alert('삭제 성공');            
        }else{
            alert('삭제 실패');
        }// if end
    }// func end
    // JS 정의/만들기 방법 3가지
    // 1. async function 함수명(){}
    // 2. function(){}
    // 3. async () => {} 
    return (
        <>
        <h3> 스프링 서버의 boardservice13(종합.예제13) </h3>
        <div>
            <input placeholder="내용" value={bcontent} onChange={ (e) => { setBcontent(e.target.value); }}/>
            <input placeholder="작성자" value={bwriter} onChange={ (e) => { setBwriter(e.target.value); }}/>
            <button onClick={ boardWrtie }> 등록 </button>
        </div>
        <div>
            <ul>
                { list.map( (b) => {
                    return <li key={ b.bno }>
                        <span>내용 :</span> {b.bcontent}
                        <span>작성자 :</span> {b.bwriter}
                        <button onClick={ () => { onUpdate(b.bcontent , b.bno ) } }> 수정 </button>
                        <button onClick={ () => { onDelete(b.bno) } }> 삭제 </button>
                    </li>
                } ) }
            </ul>
        </div>
        </>
    )
}// func end