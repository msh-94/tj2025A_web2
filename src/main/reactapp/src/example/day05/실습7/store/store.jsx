import { configureStore } from "@reduxjs/toolkit";
import userSlice from './userStore';

// [1] 스토어 생성
const store = configureStore( {
    reducer : {
        user : userSlice
    }
});
// [2] 내보내기
export default store;