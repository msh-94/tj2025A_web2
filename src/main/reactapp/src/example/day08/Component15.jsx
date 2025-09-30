import axios from "axios";

export default function Component15( props ){
    // [1]
    const axios1 = async () => {
        try{
            const response = await axios.get("http://localhost:8080/axios");
            const data = response.data;
            console.log( "[1] : " , data );
        }catch(e){ console.log(e); }
    }// func end
    // [2] 로그인 , axios.post(url , body , option)
    const axios2 = async () => {
        try{
            const obj = { id : "qwe" , password : "123" }
            const option = { withCredentials : true }
            const response = await axios.post("http://localhost:8080/axios/login" , obj , option );
            const data = response.data;
            console.log( "[2] : " , data );
        }catch(e){ console.log(e); }
    }// func end
    // [3] 내정보 , axios.get( url , option )
    const axios3 = async () => {
        try{
            const option = { withCredentials : true }
            const response = await axios.get("http://localhost:8080/axios/info" , option );
            const data = response.data;
            console.log( "[3] : " , data );
        }catch(e){ console.log(e); }
    }// func end
    return (
        <>
        <h3> AXIOS 테스트 </h3>
        <button onClick={ axios1 }> axios1 </button>
        <button onClick={ axios2 }> axios2 </button>
        <button onClick={ axios3 }> axios3 </button>
        </>
    )
}// func end