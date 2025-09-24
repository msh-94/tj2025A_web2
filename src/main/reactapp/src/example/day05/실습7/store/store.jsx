import { configureStore } from "@reduxjs/toolkit";
import userSlice from './userStore';
/* 
    스토어 : 여러개의 상태를 보관하는 저장소 , ** 1개 존재 ** 해야한다
    configureStore()
*/
/* 
    퍼시스턴스(사이드렌더링) : 로컬/세션 스토리지 에 상태 유지하는 방법
    설치 : npm i redux-persist
*/
// [1] 스토어 생성
const store = configureStore( {
    reducer : {
        user : userSlice
    }
});
// [2] 내보내기
export default store;