package example.종합.영화플랫폼.service; // 패키지명

import example.종합.영화플랫폼.model.dto.MovieDto;
import example.종합.영화플랫폼.model.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService { // class start
    // [*]
    private final MovieMapper movieMapper;

    // [1] 등록
    public boolean movieAdd(MovieDto dto){
        boolean result = movieMapper.movieAdd(dto);
        return result;
    }// func end

    // [2] 삭제
    public boolean movieDelete(int mno , int mpwd ){
        boolean result = movieMapper.movieDelete(mno , mpwd);
        return result;
    }// func end

    // [3] 전체조회
    public List<MovieDto> moviePrint(){
        List<MovieDto> result = movieMapper.moviePrint();
        return result;
    }// func end

    // [4] 개별조회
    public MovieDto movieFind(int mno){
        MovieDto result = movieMapper.movieFind(mno);
        return result;
    }// func end
}// class end
