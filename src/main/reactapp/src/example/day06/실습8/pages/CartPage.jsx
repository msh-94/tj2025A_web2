import { useSelector } from "react-redux"
import Table from '@mui/joy/Table';


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
         <Table aria-label="basic table" style={{ width: '20%' }}>
            <thead>
                <tr>
                    <th>제품명</th>
                    <th>가격(원)</th>
                    <th>갯수(개)</th>
                </tr>
            </thead>
            <tbody>
                {
                    cartInfo.map( (c) => {
                        return <tr key={c.id} >
                            <td>{c.name}</td>
                            <td>{c.price}원</td>
                            <td>{c.amount} 개</td>
                        </tr>
                    })
                }
            </tbody>
            <tfoot>
                <tr>
                    <th>총 개수(개) : <span style={{color: 'red'}}>{count}</span> 개</th>                    
                    <th>총 금액(원)</th>
                    <td>{totalPrice()}원</td>
                </tr>
            </tfoot>
         </Table>        
        </>
    )
}// func end