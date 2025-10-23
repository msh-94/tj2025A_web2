import { useDispatch } from 'react-redux';
import { login } from '../store/userStore.jsx';
import { useNavigate } from 'react-router-dom';

export default function LoginPage( props ){
    // [1] 액션을 이용한 전역변수 상태변환 함수 
    const dispatch = useDispatch();
    // [2] 페이지 이동을 위한 함수 
    const navigate = useNavigate();
    // [3] 로그인처리
    const loginPatch = () => {
            alert('로그인 성공');
            // dispatch( login() );
            const obj = { id : 3 , name : "유재석" } // login 액션에 보낼 데이터
            dispatch( login(obj) );
            navigate("/");
        }// func end
    return (
        <>
        <h3> 로그인 페이지 </h3>
        <button onClick={loginPatch}> 로그인 </button>
        </>
    )
}// func end