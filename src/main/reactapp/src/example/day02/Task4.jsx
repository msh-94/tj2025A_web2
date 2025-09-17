import { useState } from "react"
import './Task.css';
let num = 2;
export default function Task4( props ){
    const [ name , setName ] = useState('');
    const [ phone , setPhone ] = useState('');
    const [ age , setAge ] = useState(0);
    const list = [{ num : 0 , name : '신동엽' , phone : '010-7894-7894' , age : 50 } ,
                    { num : 1,  name : '강호동' , phone : '010-4321-4321' , age : 40 } ,
                    { num : 2 , name : '유재석' , phone : '010-1234-1234' , age : 30 }
    ]
    const [ array , setArray ] = useState(list);
    const listAdd = () => {
        const obj = { num : num++ , name , phone , age }
        array.push(obj);
        setArray([...array]);    
        setName('');
        setPhone('');
        setAge('');    
    }
    const listDel = (num) => {
        for(let i = 0; i < array.length; i++ ){
            if( i == num ){
                array.splice( num , 1 );
                setArray([...array]);
            }// if end
        }// for end
    }
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
                    return  <li><div><span>성명</span>: {info.name} <span>연락처</span>: {info.phone} <span>나이</span>: {info.age}</div> 
                    <div><button className="delBtn" onClick={ ()=>{ listDel(info.num); } }> 삭제 </button></div></li> 
                }) }
                
            </ul>
            <div className="countBox">총 {array.length}명</div>
        </div>        
        </>
    )
}// func end

