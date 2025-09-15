// import { StrictMode } from 'react'
// import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.jsx'

// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )


// ** main.jsx 에서 index.html의 id=root 마크업에 최초의 컴포넌트(화면함수) 렌더링하는곳
// 1. 리액트 root 함수 호출
import { createRoot } from 'react-dom/client';
// 2. index.html 에서 root 마크업 가져오기
const root = document.querySelector('#root');
// 3. 가져온 root 마크업에 렌더링할 객체 생성
const create = createRoot(root);
// 4. root에 렌더링할 컴포넌트(화면함수)
  // 4-1 렌더링하기 할 컴포넌트 (함수) 가져오기
import App from './App.jsx';
  // 4-2 렌더링하기
create.render( <App /> );