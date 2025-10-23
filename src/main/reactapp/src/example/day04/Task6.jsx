import { Routes , BrowserRouter, Route, useNavigate , Link } from "react-router-dom";
import './Task6.css';
import { useRef } from "react";

export default function Task6( props ){
        
    return (
        <>
        <BrowserRouter>
            <div className="container">
                <ul>
                    <li><Link to="/">홈</Link></li>
                    <li><Link to="/signup">회원가입</Link></li>
                    <li><Link to="/login">로그인</Link></li>                
                </ul>
                <div className="routeContainer">
                    <Routes>
                        <Route path="/" element={ <Home/> } />
                        <Route path="/signup" element={ <SignUp/> } />
                        <Route path="/login" element={ <Login/> } />
                        <Route path="*" element={ <ErrorPage/> } />
                    </Routes>
                </div>
            </div>
        </BrowserRouter>
        </>
    )
}// func end

// [1] 메인페이지
function Home( props ){
    return(
        <>
            <h3> 홈 페이지 </h3>
            <p> 좌측 메뉴에서 회원가입 또는 로그인으로 이동해보세요. </p>
        </>
    )
}// func end

// [2] 회원가입 페이지
function SignUp( props ){
    const idRef = useRef(null);
    const pwdRef = useRef(null);
    const navigate = useNavigate();
    const signUp = () => {
        // idRef.current (vs) document.querySelctor()
        // idRef.current.value (vs) document.querySelector().value
        const mid = idRef.current.value;
        const mpwd = pwdRef.current.value;
        const obj = { mid , mpwd }
        // axios 했다 치고 페이지 전환하기
        alert(' 회원가입 성공 ');
        // location.href="/login" // 라우터 방식이 아닌 고전적인 HTML 방식으로 새로고침된다
        navigate('/login');
    }
    return(
        <>
            <h3> 회원가입 페이지 </h3>
            <input ref={idRef} placeholder="아이디"/><br/>
            <input ref={pwdRef} placeholder="비밀번호"/><br/>
            <button onClick={signUp} type="button"> 회원가입 </button>
        </>
    )
}// func end

// [3] 로그인 페이지
function Login( props ){
    const navigate = useNavigate();
    const formRef = useRef(null);
    const logIn = () => { 
        const mid = formRef.current.elements['mid'].value;
        const mpwd = formRef.current.elements['mpwd'].value;
        const obj = { mid , mpwd }       
        alert('로그인 성공');
        navigate('/');       
    }// func end
    return(
        <>
            <h3> 로그인 페이지 </h3>
            <form ref={formRef}>
                <input name="mid" placeholder="아이디"/><br/>
                <input name="mpwd" placeholder="비밀번호"/><br/>
                <button onClick={logIn} type="button"> 로그인 </button>
            </form>
        </>
    )
}// func end

// [4] 오류페이지
function ErrorPage( props ){
    const navigate = useNavigate();
    const TransMain = () => {
        navigate("/");
    }// func end
    return(
        <>
            <h3> 존재하지 않는 페이지입니다.</h3>
            <button onClick={TransMain}> 메인페이지로 </button>
        </>
    )
}// func end