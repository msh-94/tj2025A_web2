import { Routes , BrowserRouter, Route, useNavigate , Link } from "react-router-dom";
import './Task6.css';
export default function Task6( props ){
    // [1] 메인페이지
    function Home( props ){
        return(
            <>
            <div>
                <h3> 홈 페이지 </h3>
                <p> 좌측 메뉴에서 회원가입 또는 로그인으로 이동해보세요. </p>
            </div>
            </>
        )
    }// func end

    // [2] 회원가입 페이지
    function SignUp( props ){
        return(
            <>
            <div>
                <h3> 회원가입 페이지 </h3>
                <input placeholder="아이디"/><br/>
                <input placeholder="비밀번호"/><br/>
                <button type="botton"> 회원가입 </button>
            </div>
            </>
        )
    }// func end

    // [3] 로그인 페이지
    function Login( props ){
        return(
            <>
            <div>
                <h3> 로그인 페이지 </h3>
                <input placeholder="아이디"/><br/>
                <input placeholder="비밀번호"/><br/>
                <button type="botton"> 로그인 </button>
            </div>
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
            <div>
                <h3> 존재하지 않는 페이지입니다.</h3>
                <button onClick={TransMain}> 메인페이지로 </button>
            </div>
            </>
        )
    }// func end
    
    return (
        <>
        <BrowserRouter>
            <div className="container">
                <ul>
                    <li><Link to="/">홈</Link></li>
                    <li><Link to="/signup">회원가입</Link></li>
                    <li><Link to="/login">로그인</Link></li>                
                </ul>
                <Routes>
                    <Route path="/" element={ <Home/> } />
                    <Route path="/signup" element={ <SignUp/> } />
                    <Route path="/login" element={ <Login/> } />
                    <Route path="*" element={ <ErrorPage/> } />
                </Routes>
            </div>
        </BrowserRouter>
        </>
    )
}// func end