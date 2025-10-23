import { Link } from 'react-router-dom';
import Box from '@mui/joy/Box';
import List from '@mui/joy/List';
import ListDivider from '@mui/joy/ListDivider';
import ListItem from '@mui/joy/ListItem';
import ListItemButton from '@mui/joy/ListItemButton';
import Home from '@mui/icons-material/Home';
import Person from '@mui/icons-material/Person';
import * as React from 'react';

export default function Header( props ){

    return (
        <>        
        <Box component="nav" aria-label="My site" sx={{ flexGrow: 1 }}>
        <List role="menubar" orientation="horizontal">
            <ListItem role="none">
            <ListItemButton
                role="menuitem"                
                aria-label="Home"
            >
                <Link to="/"><Home /></Link>
            </ListItemButton>
            </ListItem>
            <ListDivider />
            <ListItem role="none">
            <ListItemButton role="menuitem" >
                <Link to="/menu">메뉴</Link>                
            </ListItemButton>
            </ListItem>
            <ListDivider />
            <ListItem role="none">
            <ListItemButton role="menuitem" >
                <Link to="/cart">장바구니</Link>
            </ListItemButton>
            </ListItem>            
        </List>
        </Box>
        </>
    )
}// func end