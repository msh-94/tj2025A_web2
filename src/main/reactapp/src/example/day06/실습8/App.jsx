import { BrowserRouter, useNavigate, Routes ,Route } from "react-router-dom"
import Header from '../실습8/components/Header.jsx'
import HomePage from '../실습8/pages/HomePage.jsx';
import MenuPage from '../실습8/pages/MenuPage.jsx';
import CartPage from '../실습8/pages/CartPage.jsx';

export default function App( props ){
    const Page404 = () => {
        const navigate = useNavigate();
        const callBack = () => {
            navigate("/");
        }// func end
        return (
            <>
            <h3> 페이지가 존재하지 않습니다 </h3>
            <button onClick={callBack}> 홈으로 </button>
            </>
        )
    }// func end
    return (
        <>        
        <BrowserRouter>
            <Header/>                       
            <Routes>
                <Route path="/" element={ <HomePage /> } />
                <Route path="/menu" element={ <MenuPage /> } />
                <Route path="/cart" element={ <CartPage /> } />
                <Route path="*" element={ <Page404 /> } />
            </Routes>
        </BrowserRouter>
        </>
    )
}// func end