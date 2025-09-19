package example.종합.영화플랫폼.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @ToString
public class MovieDto { // class start
    private int mno;
    private String mtitle;
    private String direc;
    private String genre;
    private String comment;
    private int mpwd;
}// class end
