import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from "react-redux";
import { logout } from '../store/userStore.jsx';

export default function Header( props ){
    // [1] 전역변수 가져오기
    const { isAuthenticated } = useSelector( (state) => state.user );
    // [2] 액션을 이용한 전역변수 상태변환 함수 
    const dispatch = useDispatch();   
    // [3] 페이지 이동을 위한 함수 
    const navigate = useNavigate(); 
    // [4] 로그아웃 처리
    const logoutPatch = () => {
        alert('로그아웃 성공');
        dispatch( logout() );
        navigate("/");
    }// func end
    return (
        <>
        <h3> 헤더 </h3>
        <ul>
            <li><Link to="/">홈</Link></li>
            { isAuthenticated ?
                <><li><Link to="/profile">프로필</Link></li>
                <button onClick={logoutPatch}> 로그아웃 </button></> : 
                <><li><Link to="/login">로그인</Link></li></>                
            }
            
        </ul>
        </>
    )
}// func end