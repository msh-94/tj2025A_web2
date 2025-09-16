package example.종합.예제13.service; // 패키지명

import example.종합.예제13.model.dto.BoardDto;
import example.종합.예제13.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class BoardService { // class start
    private final BoardMapper boardMapper;

    // [1] 등록기능
    public Boolean boardWrite(BoardDto boardDto){
        return boardMapper.boardWrite(boardDto) == 1;
    }// func end

    // [2] 전체조회
    public List<BoardDto> boardPrint(){
        return boardMapper.boardPrint();
    }// func end

    // [3] 개별조회
    public BoardDto boardFind(int bno){
        return boardMapper.boardFind(bno);
    }// func end

    // [4] 개별 삭제
    public Boolean boardDelete(int bno){
        return boardMapper.boardDelete(bno) == 1;
    }// func end

    // [5] 개별 수정
    public Boolean boardUpdate(BoardDto boardDto){
        return boardMapper.boardUpdate(boardDto) == 1;
    }// func end

}// class end
