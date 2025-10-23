const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
]; 

// [3] css파일 불러오기 : import 'CSS파일경로'
import './Task2.css';

export default function Task2( props ){
    
    return (
        <>
            <div class="products">
                <Product pro = {products[0]} />
                <Product pro = {products[1]} />
                <Product pro = {products[2]} />
            </div>
        </>
     )
    
} // func end

function Product(props){    
    // 구문 분해 , props현재 상태 : { pro : { title, price, inStock}}
    const {title , price , inStock} = props.pro
    return (
        <>
            <ul class="proBox">
                <li class='titleList'> { title } </li>
                <li class='priceList'>가격 : { price.toLocaleString() } </li>
                <li style={{color:inStock == true ? 'green' : 'red' }}> { inStock == true ? '재고 있음' : '재고 없음' }</li>
            </ul>
        </>
     )
}// func end