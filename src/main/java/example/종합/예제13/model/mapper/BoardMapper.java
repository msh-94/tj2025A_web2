package example.종합.예제13.model.mapper; // 패키지명

import example.종합.예제13.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper { // interface start
    // [1] 등록기능
    @Insert("insert into board(bcontent,bwriter) values(#{bcontent} , #{bwriter}) ")
    int boardWrite(BoardDto boardDto);

    // [2] 전체조회 기능
    @Select("select * from board")
    List<BoardDto> boardPrint();

    // [3] 개별조회 기능
    @Select("select * from board where bno = #{bno}")
    BoardDto boardFind(int bno);

    // [4] 개별 삭제
    @Delete("delete from board where bno = #{bno}")
    int boardDelete(int bno);

    // [5] 개별 수정
    @Update("update board set bcontent = #{bcontent} where bno = #{bno}")
    int boardUpdate(BoardDto boardDto);
}// interface end
