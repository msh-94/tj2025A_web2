import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom";
import { countAdd } from '../store/cartSlice'

export default function MenuPage( props ){    
    const sample = [
        { id: 1, name: "아메리카노", price: 3000 }, 
        { id: 2, name: "카페라떼", price: 4000 },
        { id: 3, name: "카푸치노", price: 4500 }
    ]
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const shopping = (id , name ,price ) => {
        const obj = { id , name , price  }
        dispatch( countAdd(obj) );
        const check = confirm("장바구니로 이동하시겠습니까?");
        if(check){
            navigate("/cart");
        }else{
            navigate("/menu");
        }// if end
    }// func end
    return (
        <>
        <h3> 제품메뉴 페이지 </h3>
        <ul>
            {
                sample.map( (s) => {
                    return <li key={s.id}> 제품명 : {s.name} 가격 : {s.price} <button onClick={ (e) => { shopping(s.id,s.name,s.price) }}> 담기 </button></li>
                })
            }
        </ul>
        </>
    )
}// func end