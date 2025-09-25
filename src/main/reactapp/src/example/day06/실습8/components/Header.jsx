import { Link, useNavigate } from 'react-router-dom';
export default function Header( props ){

    return (
        <>
        <h3> 헤더 </h3>
        <ul>
            <li><Link to="/">홈</Link></li>
            <li><Link to="/menu">메뉴</Link></li>
            <li><Link to="/cart">장바구니</Link></li>
        </ul>
        </>
    )
}// func end