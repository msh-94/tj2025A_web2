import { createSlice } from "@reduxjs/toolkit"

// [1] 로그인여부 전역변수
const initialState = { isAuthenticated : false }
// [2] 리듀서 함수 정의
const userSlice = createSlice( {
    name : "user" ,
    initialState ,
    reducers : {
        login : ( state ) => { state.isAuthenticated = true; },
        logout : ( state ) => { state.isAuthenticated = false; }
    }
});

// [3] 내보내기
export const { login , logout } = userSlice.actions;