// day05 -> userSlice.jsx

import { createSlice } from '@reduxjs/toolkit'

// [1] 리덕스 설치 : reactapp 폴더 오른쪽 클릭 --> 터미널열기
// [리액트 종료된 상태]
// npm i @reduxjs/toolkit
// npm i react-redux
// [리액트 재실행] npm run dev

// [2] 전역변수의 초기값 , '로그인 여부'를 저장하는 상태 ture:로그인됨 , false : 로그인안됨
const initialState = { isAuthenticated : false } 

// [3] 상태를 변경하는 리듀서 함수들을 정의
// createSlice( { name : 'slice이름', 초기값 , reducers : { 액션함수명 : (state) => { } } } );
const userSlice = createSlice( {
    name : "user" , // slice의 이름 , 하나의 저장소(store)에 저장되는 일부분의 값 의 이름
    initialState , // [2] 정의한 객체로 초기값 설정 , 추후에 다양하게 저장 가능 , 단 노출이 위험한 정보제외
    
});