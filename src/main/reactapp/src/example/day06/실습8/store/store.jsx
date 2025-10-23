import { persistStore , persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
import cartSlice from './cartSlice';
import { configureStore } from '@reduxjs/toolkit';

const persistConfig = { key : 'cart' , storage }
const persistedReducer = persistReducer( persistConfig , cartSlice );

const store = configureStore( {
    reducer : { cart : persistedReducer }
})

export default store;
export const per = persistStore( store );