import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom";
import { countAdd } from '../store/cartSlice'
import Table from '@mui/joy/Table';
import Button from '@mui/joy/Button';



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
        <Table aria-label="basic table" style={{ width: '30%' }}>
            <thead>
                <tr>
                    <th>제품명</th>
                    <th>가격(원)</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                {
                    sample.map( ( s ) => {
                        return <tr key={s.id}>
                            <td>{s.name}</td>
                            <td>{s.price}원</td>
                            <td><Button variant="outlined" onClick={ () => { shopping(s.id,s.name,s.price) }}>  장바구니에 담기 </Button></td>
                        </tr>
                    })
                }
            </tbody>
        </Table>        
        </>
    )
}// func end