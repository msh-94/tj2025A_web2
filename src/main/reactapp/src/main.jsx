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
// import App from './App.jsx';
// 4-2 렌더링하기k
// create.render( <App /> );

// * 2 ~ 4-2 요약가능
// createRoot( document.querySelector('#root').render( <App /> ));

// day01
import Component1 from './example/day01/Component1.jsx';
import Component2 from './example/day01/Component2.jsx';
import Component3 from './example/day01/Component3.jsx';
import Task1 from './example/day01/Task1.jsx';
import Task2 from './example/day01/Task2.jsx';

// *** render 1번만 가능하다 ***
// create.render( <Component1/> );
// create.render( <Component2/> );
// create.render( <Component3/> );
// create.render( <Task1/> );
// create.render( <Task2/> );

// day02
import Component4 from './example/day02/Component4.jsx';
import Component5 from './example/day02/Component5.jsx';
import Component6 from './example/day02/Component6.jsx';
import Component7 from './example/day02/Component7.jsx';
import Task3 from './example/day02/task3.jsx';
// create.render( <Component4 /> );
// create.render( <Component5 /> );
// create.render( <Component6 /> );
// create.render( <Component7 /> );
create.render( <Task3 /> );