import { createSlice } from "@reduxjs/toolkit";

const initialState = { count : 0 , cartInfo : [] }

const cartSlice = createSlice( {
    name : 'cart' ,
    initialState ,
    reducers : {
        countAdd : ( state , action ) => {
            state.count += 1

            // 방법1
            // const cartList = state.cartInfo.find(c => c.id === action.payload.id);
            // if (cartList) {
            //     cartList.amount += 1;
            // } else {
            //     state.cartInfo.push({ ...action.payload, amount : 1 });
            // }// if end

            // 방법2
            let found = false;
            state.cartInfo.forEach( (c) => {
                if(c.id == action.payload.id){ c.amount += 1; found = true; }
            })
            if(!found){ state.cartInfo.push({...action.payload , amount : 1 })}
        }
    }
});

export default cartSlice.reducer
export const { countAdd } = cartSlice.actions;
