// 서버로 부터 권한을 확인하여 해당 권한에 따른 컴포넌트를 제약
import axios from 'axios';
import { useEffect, useState } from "react";
import { Navigate, Outlet } from "react-router-dom";

export default function RoleRoute( props ){
    // -props란 ? 상위 컴포넌트에서 해당 컴포넌트로 부터 전달받은 속성들
    console.log(props);

    // - useState : 현재 컴포넌트내 상태(값저장) 변수 +렌더링(새로고침)
    const [ auth , setAuth ] = useState( { isAuth : null , urole : null } );

    // [1] 서버로 부터 권한 요청
    const checkAuth = async () => {
        try{
            const url = "http://localhost:8080/api/user/check";
            const res = await axios.get( url , { withCredentials : ture });
            // "withCredentials" : httpOnly 쿠키 자동 포함하기 위해서 필수 옵션
            setAuth( res.data );
            console.log( res.data );
        }catch(e){ setAuth( {isAuth : false , urole : null } ) }
    }// func end

    // [2] 최초 렌더링 1번 권한 검증 , useEffect 이란? 컴포넌트의 생명주기에 따른 특정 작업 실행
    useEffect( () => { checkAuth() } , [] );

    // [3] 만약에 서버로 부터 권한을 못받았다면
    if( auth.isAuth == null ) return <div> 권한 확인중... </div>;

    // [4] 로그인 (쿠키/토큰) 안했다면 로그인 페이지로 이동
    if( auth.isAuth == false ) return <Navigate to="/login" />;

    // [5] 상위 컴포넌트(App.jsx)로 부터 전달받은 권한중에 서버가 전달한 권한이 없으면 권한 없음
    if( !props.roles.includes( auth.urole ) ) return <Navigate to="/forbidden" />;

    // [6] 3,4,5 통과 했다면 자식 컴포넌트 보여주기 , <Outlet> 자식 컴포넌트 렌더링하기
    return <Outlet/>
}// func end

