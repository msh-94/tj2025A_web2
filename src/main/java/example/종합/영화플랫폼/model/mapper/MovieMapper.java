package example.종합.영화플랫폼.model.mapper; // 패키지명

import example.종합.영화플랫폼.model.dto.MovieDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper { // interface start
    // [1] 등록
    @Insert("insert into movie(mtitle,direc,genre,comment,mpwd) values( #{mtitle} ,#{direc} ,#{genre} ,#{comment} ,#{mpwd} )")
    boolean movieAdd(MovieDto movieDto);

    // [2] 삭제
    @Delete("delete from movie where mpwd = #{mpwd} and mno = #{mno}")
    boolean movieDelete(int mno , int mpwd);

    // [3] 전체조회
    @Select("select * from movie")
    List<MovieDto> moviePrint();

    // [4] 개별조회
    @Select("select * from movie where mno = #{mno}")
    MovieDto movieFind(int mno);
}// interface end
