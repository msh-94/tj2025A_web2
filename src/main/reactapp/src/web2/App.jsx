import { BrowserRouter as Router , Routes , Route , Link } from 'react-router-dom'; 
export default function App( props ){

    return(
        <>
        <Router>
            <div> 헤더 </div>
            <Routes>
                {/* 권한에 따른 제약조건 추가 */}
                {/* 1. 누구나 접근 가능 */}
                
                {/* 2. USER 또는 그외 접근 가능 */}

                {/* 3. ADMIN 또는 그욉 접근 가능 */}
            </Routes>
        </Router>
        </>
    )
} // func end