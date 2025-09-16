// REACT 실습1 : Task1과 Profile 컴포넌트를 완성하시오.

// Fecth 이용하여 서버로 부터 받은 데이터/자료 
const data = [
  {
    name: 'Hedy Lamarr',
    imageUrl:'https://i.pravatar.cc/150?img=47'
  },
  {
    name: 'Grace Hopper',
    imageUrl: 'https://i.pravatar.cc/150?img=48'
  }
];

export default function Task1( props ){
    return (<>
            <h2> {data[0].name} </h2>
            <img src={data[0].imageUrl}/>
            <Profile name = {data[1].name} imageUrl = {data[1].imageUrl}/>
            </>)
}// func end

function Profile( props ) {
    const { name , imageUrl } = props
    return (<>
            <h2> {name} </h2>
            <img src={imageUrl} />
            </> );
}// func end
