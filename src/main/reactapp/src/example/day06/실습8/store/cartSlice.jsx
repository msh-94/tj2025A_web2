import { createSlice } from "@reduxjs/toolkit";

const initialState = { count : 0 , cartInfo : [] }

const cartSlice = createSlice( {
    name : 'cart' ,
    initialState ,
    reducers : {
        countAdd : ( state , action ) => {
            state.count += 1
            const cartList = state.cartInfo.find(c => c.id === action.payload.id);
            if (cartList) {
                cartList.amount += 1;
            } else {
                state.cartInfo.push({ ...action.payload, amount: 1 });
            }// if end
        }
    }
});

export default cartSlice.reducer
export const { countAdd } = cartSlice.actions;
