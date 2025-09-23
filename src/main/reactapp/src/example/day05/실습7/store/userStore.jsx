import { createSlice } from "@reduxjs/toolkit"

/* 
    슬라이스 : 상태(state) , 리듀서(reducer) , 액션(action) 정의하는 곳
    createSlice()
*/

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
export default userSlice.reducer // 현재 정의한 리듀서(reducers)들을 store 등록 예정
export const { login , logout } = userSlice.actions;