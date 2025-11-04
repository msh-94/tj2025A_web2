package example2.종합.실습2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table( name = "movie" )
public class MovieEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_Id;
    @Column( nullable = false , length = 50 )
    private String title;
    @Column( nullable = false , length = 20 )
    private String director;
    @Column( nullable = false )
    private String releaseDate;
    private double rating;

    public MovieDto toDto(){
        return MovieDto.builder()
                .movie_Id( this.movie_Id )
                .director( this.director )
                .releaseDate( this.releaseDate )
                .title( this.title )
                .rating( this.rating )
                .build();
    }// f end

}// class end
