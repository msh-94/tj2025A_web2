import { createSlice } from "@reduxjs/toolkit";

const initialState = { count : 0 , cartInfo : [] }

const cartSlice = createSlice( {
    name : 'cart' ,
    initialState ,
    reducers : {
        countAdd : ( state , action ) => {
            state.count += 1
            state.cartInfo.push(action.payload) 
        }
    }
});

export default cartSlice.reducer
export const { countAdd } = cartSlice.actions;
