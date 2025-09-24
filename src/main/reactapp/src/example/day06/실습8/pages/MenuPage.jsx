import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom";
import { countAdd } from '../store/cartSlice'

export default function MenuPage( props ){
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const shopping = (id ,name , price) => {
        const obj = { id, name , price }
        dispatch( countAdd(obj) );
        confirm("장바구니로 이동하시겠습니까?");
        if(confirm){
            navigate("/cart");
        }else{
            navigate("/menu");
        }// if end
    }// func end
    return (
        <>
        <h3> 제품메뉴 페이지 </h3>
        <ul>
            <li>
                제품번호 : <span>1</span>
                제품명 : <span>아메리카노</span>
                가격 : <span>3000</span>
                <button onClick={ () => {shopping(1,"아메리카노",3000)}}> 담기 </button>
            </li>
            <li>
                제품번호 : <span>2</span>
                제품명 : <span>카페라떼</span>
                가격 : <span>4000</span>
                <button onClick={ () => {shopping(2,"카페라떼",4000)}}> 담기 </button>
            </li>
            <li>
                제품번호 : <span>3</span>
                제품명 : <span>카푸치노</span>
                가격 : <span>4500</span>
                <button onClick={ () => {shopping(1,"카푸치노",4500)}}> 담기 </button>
            </li>
        </ul>
        </>
    )
}// func end