package example2.종합.실습2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    // [1] 등록
    public MovieDto save(MovieDto dto){
        MovieEntity entity = movieRepository.save(dto.toEntity());
        return entity.toDto();
    }// func end

    // [2] 전체조회
    public List<MovieDto> findAll(){
        return movieRepository.findAll().stream()
                .map(MovieEntity :: toDto).toList();
    }// func end

    // [3] 개별 조회
    public MovieDto find(int movie_id){
        Optional<MovieEntity> optional = movieRepository.findById(movie_id);
        if (optional.isPresent()){
            MovieEntity entity = optional.get();
            return entity.toDto();
        }// if end
        return null;
    }// func end

    // [4] 개별 수정
    public MovieDto update(MovieDto dto){
        Optional<MovieEntity> optional = movieRepository.findById(dto.getMovie_Id());
        if (optional.isPresent()){
            MovieEntity entity = optional.get();
            entity.setDirector(dto.getDirector());
            entity.setRating(dto.getRating());
            entity.setTitle(dto.getTitle());
            entity.setReleaseDate(dto.getReleaseDate());
            return entity.toDto();
        }// if end
        return dto;
    }// func end

    // [5] 개별 삭제
    public boolean delete(int movie_id){
        if (movieRepository.existsById(movie_id)){
            movieRepository.deleteById(movie_id);
            return true;
        }// if end
        return false;
    }// func end

}// class end
