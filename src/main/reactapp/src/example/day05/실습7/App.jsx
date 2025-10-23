import { BrowserRouter, useNavigate ,  Routes , Route } from "react-router-dom";
import HomePage from "../실습7/pages/HomePage.jsx";
import LoginPage from "../실습7/pages/LoginPage.jsx";
import ProfilePage from "../실습7/pages/ProfilePage.jsx";
import Headers from "../실습7/components/Header.jsx";

export default function App( props ){
    const Page404 = () => {
        const navigate = useNavigate();
        const callback = () => {
            navigate("/");
        }// func end
        return (
            <>
            <h3> 페이지가 존재하지 않습니다 </h3>
            <button onClick={callback}> 홈으로 </button>
            </>
        )
    }// func end
    return (      
        <>
        <BrowserRouter>            
            <h3> 루트 페이지 </h3>
            <Headers/>            
            <Routes>
                <Route path="/" element={ <HomePage/> } />
                <Route path="/login" element={ <LoginPage/> } />
                <Route path="/profile" element={ <ProfilePage/> } />
                <Route path="*" element={ <Page404/> } />
            </Routes>
        </BrowserRouter>
        </>  
    )
}// func end