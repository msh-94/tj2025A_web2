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
// *** render 1번만 가능하다 ***
import Component1 from './example/day01/Component1.jsx';
// create.render( <Component1/> );
import Component2 from './example/day01/Component2.jsx';
// create.render( <Component2/> );
import Component3 from './example/day01/Component3.jsx';
// create.render( <Component3/> );
import Task1 from './example/day01/Task1.jsx';
// create.render( <Task1/> );
import Task2 from './example/day01/Task2.jsx';
// create.render( <Task2/> );

// day02
import Component4 from './example/day02/Component4.jsx';
// create.render( <Component4 /> );
import Component5 from './example/day02/Component5.jsx';
// create.render( <Component5 /> );
import Component6 from './example/day02/Component6.jsx';
// create.render( <Component6 /> );
import Component7 from './example/day02/Component7.jsx';
// create.render( <Component7 /> );
import Task3 from './example/day02/task3.jsx';
// create.render( <Task3 /> );
import Task4 from './example/day02/Task4.jsx';
// create.render( <Task4 /> );

// day03
import Component8 from './example/day03/Component8.jsx';
// create.render( <Component8 /> );
import Component9 from './example/day03/Component9.jsx';
// create.render( <Component9 /> );
import Component10 from './example/day03/Component10.jsx';
// create.render( <Component10 /> );
import Task5 from './example/day03/Task5.jsx';
// create.render( <Task5 /> );

// day04
import Movie from './example/day04/movie.jsx';
// create.render( <Movie /> );
import Component11 from './example/day04/Component11.jsx';
create.render( <Component11 /> );