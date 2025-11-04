package example2.종합.실습2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MovieDto {
    private int movie_Id;
    private String title;
    private String director;
    private String releaseDate;
    private double rating;
    private String created_At;
    private String update_At;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .movie_Id( this.movie_Id )
                .director( this.director )
                .releaseDate( this.releaseDate )
                .title( this.title )
                .rating( this.rating )
                .build();
    }// f end

}// class end
