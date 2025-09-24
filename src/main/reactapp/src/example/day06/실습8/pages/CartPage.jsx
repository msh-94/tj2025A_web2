import { useSelector } from "react-redux"

export default function CartPage( props ){
    const { count , cartInfo } = useSelector( (state) => state.cart )
    const totalPrice = () => {
        let total = 0;
        for(let i = 0; i < cartInfo.length; i++){
            total += cartInfo[i].price;
        }// for end
        return total;
    }// func end
    return (
        <>
        <h3> 장바구니 페이지 </h3>
        <div>
            <div>총 개수 : <p> {count}개 </p></div>            
            <ul>
                { cartInfo.map( ( c ) => {
                    return <li key={c.id}>제품명 : {c.name} 가격 : {c.price}</li>                    
                })}                
            </ul>
            <div>총 금액 : <p> {totalPrice}원 </p></div>            
        </div>
        </>
    )
}// func 