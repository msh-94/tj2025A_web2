import * as React from 'react';
import Box from '@mui/joy/Box';
import List from '@mui/joy/List';
import ListItem from '@mui/joy/ListItem';
import ListItemButton, { listItemButtonClasses } from '@mui/joy/ListItemButton';
import IconButton from '@mui/joy/IconButton';
import Typography from '@mui/joy/Typography';
import ReceiptLong from '@mui/icons-material/ReceiptLong';
import KeyboardArrowDown from '@mui/icons-material/KeyboardArrowDown';

export default function SideBar( props ){
    const [open, setOpen] = React.useState(false);
    const [open2, setOpen2] = React.useState(false);
    return(
        <>
        <Box sx={{ width: 320, pl: '24px' }}>
            <List
                size="sm"
                sx={(theme) => ({
                // Gatsby colors
                '--joy-palette-primary-plainColor': '#8a4baf',
                '--joy-palette-neutral-plainHoverBg': 'transparent',
                '--joy-palette-neutral-plainActiveBg': 'transparent',
                '--joy-palette-primary-plainHoverBg': 'transparent',
                '--joy-palette-primary-plainActiveBg': 'transparent',
                [theme.getColorSchemeSelector('dark')]: {
                    '--joy-palette-text-secondary': '#635e69',
                    '--joy-palette-primary-plainColor': '#d48cff',
                },
                '--List-insetStart': '32px',
                '--ListItem-paddingY': '0px',
                '--ListItem-paddingRight': '16px',
                '--ListItem-paddingLeft': '21px',
                '--ListItem-startActionWidth': '0px',
                '--ListItem-startActionTranslateX': '-50%',
                [`& .${listItemButtonClasses.root}`]: {
                    borderLeftColor: 'divider',
                },
                [`& .${listItemButtonClasses.root}.${listItemButtonClasses.selected}`]: {
                    borderLeftColor: 'currentColor',
                },
                '& [class*="startAction"]': {
                    color: 'var(--joy-palette-text-tertiary)',
                },
                })}
            >
                <ListItem nested>
                <ListItem component="div" startAction={<ReceiptLong />}>
                    <Typography level="body-xs" sx={{ textTransform: 'uppercase' }}>
                    사이드바
                    </Typography>
                </ListItem>
                <List sx={{ '--List-gap': '0px' }}>
                    <ListItem>
                    <ListItemButton selected>홈</ListItemButton>
                    </ListItem>
                </List>
                </ListItem>
                <ListItem sx={{ '--List-gap': '0px' }}>
                <ListItemButton>로그인</ListItemButton>
                </ListItem>
                <ListItem
                nested
                sx={{ my: 1 }}
                startAction={
                    <IconButton
                    variant="plain"
                    size="sm"
                    color="neutral"
                    onClick={() => setOpen(!open)}
                    >
                    <KeyboardArrowDown
                        sx={[
                        open ? { transform: 'initial' } : { transform: 'rotate(-90deg)' },
                        ]}
                    />
                    </IconButton>
                }
                >
                <ListItem>
                    <Typography
                    level="inherit"
                    sx={[
                        open
                        ? { fontWeight: 'bold', color: 'text.primary' }
                        : { fontWeight: null, color: 'inherit' },
                    ]}
                    >
                    제품
                    </Typography>
                    <Typography component="span" level="body-xs">
                    4
                    </Typography>
                </ListItem>
                {open && (
                    <List sx={{ '--ListItem-paddingY': '8px' }}>
                    <ListItem>
                        <ListItemButton>제품목록</ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>
                        제품등록
                        </ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>
                        제품수정
                        </ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>제품삭제</ListItemButton>
                    </ListItem>
                    </List>
                )}
                </ListItem>
                <ListItem
                nested
                sx={{ my: 1 }}
                startAction={
                    <IconButton
                    variant="plain"
                    size="sm"
                    color="neutral"
                    onClick={() => setOpen2((bool) => !bool)}
                    >
                    <KeyboardArrowDown
                        sx={[
                        open2 ? { transform: 'initial' } : { transform: 'rotate(-90deg)' },
                        ]}
                    />
                    </IconButton>
                }
                >
                <ListItem>
                    <Typography
                    level="inherit"
                    sx={[
                        open2
                        ? { fontWeight: 'bold', color: 'text.primary' }
                        : { fontWeight: null, color: 'inherit' },
                    ]}
                    >
                    설정
                    </Typography>
                    <Typography component="span" level="body-xs">
                    4
                    </Typography>
                </ListItem>
                {open2 && (
                    <List sx={{ '--ListItem-paddingY': '8px' }}>
                    <ListItem>
                        <ListItemButton>Overview</ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>Local Development</ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>Routing</ListItemButton>
                    </ListItem>
                    <ListItem>
                        <ListItemButton>Styling</ListItemButton>
                    </ListItem>
                    </List>
                )}
                </ListItem>
            </List>
        </Box>
        </>
    )
}