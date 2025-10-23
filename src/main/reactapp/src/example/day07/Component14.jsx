import Button from '@mui/joy/Button';
import Box from '@mui/joy/Box';
import Input from '@mui/joy/Input';
import Select from '@mui/joy/Select';
import Option from '@mui/joy/Option';
import Switch from '@mui/joy/Switch';
import { useState } from 'react';
import Avatar from '@mui/joy/Avatar';
import SideBar from './SideBar';



export default function Component14( props ){
    const handleChange = (event, newValue) => {
        alert(`You chose "${newValue}"`);
    };
    const [checked, setChecked] = useState(false);
    return(
        <>
        <h6> MUI 설치 : npm install @mui/joy @emotion/react @emotion/styled </h6>
        <p> 소문자 마크업 : html , 대문자 마크업 : 컴포넌트( 다른 패키지이면 import ) </p>
        <button> html </button>
        <Button variant="solid">Hello world</Button>
        <p> 2. 마크업 속성 props 이란 : 마크업 안에 마크업 속성명=속성값  </p>

        <h1> 버튼 : https://mui.com/joy-ui/react-button/ </h1>
        <Box sx={{ display: 'flex', gap: 2, flexWrap: 'wrap' }}>
            <Button>Button</Button>
            <Button disabled>Disabled</Button>
            <Button loading>Loading</Button>
        </Box>

        <h1> 입력상자 : https://mui.com/joy-ui/react-input/ </h1>
        <Input placeholder="Type in here…" variant="outlined" size="md" color="primary" />

        <h1> 선택상자 : https://mui.com/joy-ui/react-select/ </h1>
        <Select defaultValue="dog" onChange={handleChange}>
            <Option value="dog">Dog</Option>
            <Option value="cat">Cat</Option>
            <Option value="fish">Fish</Option>
            <Option value="bird">Bird</Option>
        </Select>

        <h1> 4. 스위치 On/Off : https://mui.com/joy-ui/react-switch/ </h1>
        <Switch
            checked={checked}
            onChange={(event) => setChecked(event.target.checked)}
        />

        <h1> 5. 아바타 : https://mui.com/joy-ui/react-avatar/ </h1>
        <p> Box 는 div 와 같은 유형 , css 적용하는 방법 : 1.CSS파일(권장) 2.CSS객체 </p>
        <Box sx={{ display: 'flex', gap: 2 , }} style={ { backgroundColor: 'black' } }>
            <Avatar />
            <Avatar>JG</Avatar>
            <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
        </Box>

        <h1> 6. 리스트 : https://mui.com/joy-ui/react-list/ </h1>
        <p> npm install @mui/icons-material </p>
        <SideBar />
        </>
    )

    /* 
        1. 리액트에서 CSS 적용하는 방법
            방법1) CSS파일 생성한다 --> CSS 파일을 적용할 컴포넌트 에서 import 'css파일경로'
            방법2) CSS객체 --> JSX에서 객체유형으로 CSS 작성한다
                style={ { fontSize: '10' , backgroundColor: 'black' } }
    */

}// func end