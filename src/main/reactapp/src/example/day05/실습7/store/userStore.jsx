import { createSlice } from "@reduxjs/toolkit"

/* 
    슬라이스 : 상태(state) , 리듀서(reducer) , 액션(action) 정의하는 곳
    createSlice()
*/

// [1] 로그인여부 전역변수
const initialState = { isAuthenticated : false , userInfo : null }
// [2] 리듀서 함수 정의
const userSlice = createSlice( {
    name : "user" ,
    initialState ,
    reducers : {
        login : ( state , action ) => { 
            state.isAuthenticated = true; 
            // action 할때 전달되는 매개변수들을 payload 안에 값이 들어있다
            // 예] dispath( login( "안녕" ) ) , payload = "안녕"
            state.userInfo = action.payload; 
        },
        logout : ( state ) => { 
            state.isAuthenticated = false;
            state.userInfo = null;
        }
    }
});

// [3] 내보내기
export default userSlice.reducer // 현재 정의한 리듀서(reducers)들을 store 등록 예정
export const { login , logout } = userSlice.actions;