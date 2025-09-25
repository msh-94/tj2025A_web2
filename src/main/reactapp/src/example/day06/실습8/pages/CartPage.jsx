import { useSelector } from "react-redux"

export default function CartPage( props ){
    const { count , cartInfo } = useSelector( (state) => state.cart )
    const totalPrice = () => {
        let total = 0;
        for(let i = 0; i < cartInfo.length; i++){
            if(cartInfo[i].amount == 1){
                total += cartInfo[i].price;
            }else{
                total += cartInfo[i].price * cartInfo[i].amount;
            }// if end            
        }// for end
        return total;
    }// func end
    return (
        <>
        <h3> 장바구니 페이지 </h3>
        <div>
            <div>총 개수 : <span> {count}개 </span></div>            
            <ul>
                {cartInfo.map( ( c ) => {
                    return <li key={c.id}>제품명 : {c.name} 가격 : {c.price}원 개수 {c.amount}개</li>                    
                })}                
            </ul>
            <div>총 금액 : <span> {totalPrice()}원 </span></div>            
        </div>
        </>
    )
}// func end