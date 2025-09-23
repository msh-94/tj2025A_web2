import { configureStore } from "@reduxjs/toolkit";
import userSlice from './userStore';
/* 
    스토어 : 여러개의 상태를 보관하는 저장소 , ** 1개 존재 ** 해야한다
    configureStore()
*/
// [1] 스토어 생성
const store = configureStore( {
    reducer : {
        user : userSlice
    }
});
// [2] 내보내기
export default store;