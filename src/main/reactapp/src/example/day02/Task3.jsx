import { useState } from "react"

export default function Task3( props ){
    const [ data , setData ] = useState('');
    const [ stock , setStock ] = useState(0);
    return (
        <>
        <h3> Task3 </h3>
        제품명 : <input value={ data } onChange={ (e) => { setData( e.target.value ); } }/>
        <h4> 현재 수량 : { stock } </h4>
        <button onClick={ () => { setStock( stock - 1 ); }}> 감소 </button>
        <button onClick={ () => { setStock( stock + 1 ); }}> 증가 </button>        
        </>
    )
}// func end