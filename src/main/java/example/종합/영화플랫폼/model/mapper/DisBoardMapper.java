package example.종합.영화플랫폼.model.mapper; // 패키지명

import example.종합.영화플랫폼.model.dto.DisBoardDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DisBoardMapper { // interface start
    // [1] 등록
    @Insert("insert into disboard(dcontent, dpwd , mno) values( #{dcontent} , #{dpwd} , #{mno} )")
    boolean disBoardAdd(DisBoardDto dto);

    // [2] 삭제
    @Delete("delete from disboard where mno = #{mno} and dpwd = #{dpwd}")
    boolean disBoardDelete(int mno , int dpwd);

    // [3] 개별조회
    @Select("select * from disboard where mno = #{mno}")
    List<DisBoardDto> disBoardPrint(int mno);
}// interface end
