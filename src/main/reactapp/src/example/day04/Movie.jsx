import axios from "axios";
import { useEffect, useState } from "react"

export default function Movie( props ){
    const [ mtitle , setMtitle ] = useState('');
    const [ direc , setDirec ] = useState('');
    const [ genre , setGenre ] = useState('');
    const [ comment , setComment ] = useState('');
    const [ mpwd , setMpwd ] = useState('');
    const [ list , setList ] = useState([ ]);
    const [selectedMno, setSelectedMno] = useState('');
    // [1] 등록
    const movieAdd = async () => {
        const obj = { mtitle , direc , genre , comment , mpwd }
        const response = await axios.post("http://localhost:8080/movie",obj);
        if(response.status == 200){
            alert('등록 성공');
            setMtitle('');
            setDirec('');
            setGenre('');
            setComment('');
            setMpwd('');
            moviePrint();
        }else{
            alert('등록 실패');
        }// if end
    }// func end
    // [2] 전체조회
    const moviePrint = async() => {
        const response = await axios.get("http://localhost:8080/movie");
        if(response.status == 200){
            setList(response.data);
        }// if end
    }// func end
    useEffect( () => { moviePrint() } , [] )
    // [3] 삭제
    const movieDelete = async(mno , mpwd) => {
        const newMpwd = parseInt(prompt('비밀번호 : '));
        if(newMpwd == mpwd){            
            const response = await axios.delete(`http://localhost:8080/movie?mno=${mno}&mpwd=${mpwd}`  ); 
            if(response.status == 200){
            setList(list.filter( (m) => m.mno != mno ))
            alert('삭제 성공');
            }else{
                alert('삭제 실패');
            }// if end          
        }else{
            alert('입력하신 비밀번호가 일치하지않습니다.');
        }// if end
    }// func end    
    
    return (
        <>
        <div className="wrap">
            <div>
                <h3 className="titleName"> 영화 플랫폼 </h3>
            </div>
            <div>
                <input placeholder="제목" value={mtitle} onChange={ (e) => { setMtitle(e.target.value); } }/>
                <input placeholder="감독" value={direc} onChange={ (e) => { setDirec(e.target.value); } }/>
                <input placeholder="장르" value={genre} onChange={ (e) => { setGenre(e.target.value); } }/>
                <input placeholder="소개" value={comment} onChange={ (e) => { setComment(e.target.value); } }/>
                <input placeholder="비밀번호" value={mpwd} onChange={ (e) => { setMpwd(e.target.value); } }/>
                <button className="addBtn" onClick={ movieAdd }> 등록 </button>
            </div>
            <table>
                <thead>
                    <tr><th>번호</th><th>제목</th><th>감독</th><th>장르</th><th>소개</th><th>삭제</th></tr>
                </thead>
                <tbody>
                    { list.map( (m) => {
                        return <tr key={m.mno} onClick={() => setSelectedMno(selectedMno === m.mno ? null : m.mno)}>
                            <td>{m.mno}</td><td>{m.mtitle}</td><td>{m.direc}</td><td>{m.genre}</td><td>{m.comment}</td>
                            <td><button className="delBtn" onClick={ (e) => {e.stopPropagation();movieDelete(m.mno , m.mpwd)}}> 삭제 </button></td></tr>
                    }) }
                </tbody>
            </table>
            {selectedMno && <Find mno={selectedMno}  onClose={() => setSelectedMno(null)} />}
        </div>
        </>
    )
}// func end

function Find( {mno , onClose} ){
    const [ dcontent , setDcontent ] = useState('')
    const [ dpwd , setDpwd ] = useState('')
    const [ review , setReview ] = useState([])
    // [1] 등록
    const disBoardAdd = async() => {
        const obj = { dcontent , dpwd , mno }
        const response = await axios.post("http://localhost:8080/disboard" , obj);
        if(response.status == 200){
            alert('등록 성공');
            setDcontent('');
            setDpwd('');
            disBoardPrint();
        }else{
            alert('등록 실패');
        }// if end
    }// func end
    // [2] 개별조회
    const disBoardPrint = async() => {
        const response = await axios.get(`http://localhost:8080/disboard?mno=${mno}`)
        setReview(response.data);
    }// func end
    useEffect( () => { disBoardPrint() } , [] )
    // [3] 삭제
    const disBoardDelete = async(dno ,dpwd) => {
        const newDpwd = parseInt(prompt('비밀번호 : '));
            if(newDpwd == dpwd){
                const response = await axios.delete(`http://localhost:8080/disboard?mno=${mno}&dpwd=${dpwd}`)
                if(response.status == 200 ){
                    setReview(review.filter( (f) => f.dno != dno))
                    alert('삭제 성공');
                }else{
                    alert('삭제 실패');
                }
            }else{
                alert('입력하신 비밀번호가 일치하지않습니다.');
            }// if end
    }// func end
    return (
        <>        
        <h3 className="titleName"> 상세 페이지 </h3>
        <div>
            <div>
                <input placeholder="내용" value={dcontent} onChange={ (e) => {setDcontent( e.target.value ); }}/>
                <input placeholder="비밀번호" value={dpwd} onChange={ (e) => {setDpwd( e.target.value ); }}/>
                <button className="addBtn" onClick={ disBoardAdd }> 등록 </button>
            </div>
            <table className="reviewBox">
                <thead>
                    <tr>
                        <th>번호</th><th>내용</th><th>비고</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        review.map( (r) => {
                            return <tr key={r.dno}>
                                <td>{r.dno}</td><td>{r.dcontent}</td>
                                <td><button className="delBtn" onClick={ () => {disBoardDelete(r.dno ,r.dpwd)}}> 삭제 </button></td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
            <button className="closeBtn" onClick={onClose}> 닫기 </button>
        </div>        
        </>
    )
}// func end