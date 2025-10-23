import { configureStore } from "@reduxjs/toolkit";
import userSlice from './userStore';
/* 
    스토어 : 여러개의 상태를 보관하는 저장소 , ** 1개 존재 ** 해야한다
    configureStore()
*/
/* 
    퍼시스턴스(사이드렌더링) : 로컬/세션 스토리지 에 상태 유지하는 방법
    1. 설치 : npm i redux-persist
    2. 스토리지 설정
*/
// [4] redux-persist 설정
import storage from 'redux-persist/lib/storage'; // localStorage 사용
import storageSession from 'redux-persist/lib/storage/session'; // session 사용
// const persistConfig = { ket : 'key이름' , storage }
const persistConfig = { key : 'user' , storage } // localStorage 에 'user' 라는 이름으로 상태 저장

// [5] 리듀서에 persist 설정 적용
import { persistStore , persistReducer } from 'redux-persist';
// const persistedReducer = persistedReducer( 옵션 , 설정할리듀서 );
const persistedReducer = persistReducer( persistConfig , userSlice );

// [1] 스토어 생성
const store = configureStore( {
    reducer : {
        // user : userSlice // 퍼시스턴스 *적용전*
        // [6] 퍼시스턴스 적용된 리듀서를 스토어 등록
        user : persistedReducer // 퍼시스턴스 *적용후*
    }
});
// [2] 내보내기
export default store;
// [7] 등록된 퍼시스턴스 스토어 내보내기
export const persistor = persistStore( store );
