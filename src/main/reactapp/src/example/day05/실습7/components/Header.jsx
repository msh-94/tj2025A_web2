import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from "react-redux";
import { login , logout } from '../store/userStore';

export default function Header( props ){
    // [1] 전역변수 가져오기
    const { isAuthenticated } = useSelector( (state) => state.user );
    // [2] 액션을 이용한 전역변수 상태변환 함수 
    const dispatch = useDispatch();
    // [3] 로그인 처리
    const loginPatch = () => {
        dispatch( login() );
    }// func end
    // [4] 로그아웃 처리
    const logoutPatch = () => {
        dispatch( logout() );
    }// func end
    return (
        <>
        <h3> 헤더 </h3>
        <ul>
            <li><Link to="/">홈</Link></li>
            <li><Link to="/login">로그인</Link></li>
            <li><Link to="/profile">프로필</Link></li>
        </ul>
        </>
    )
}// func end