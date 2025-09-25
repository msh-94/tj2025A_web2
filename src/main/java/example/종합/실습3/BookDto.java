package example.종합.실습3; // 패키지명

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BookDto { // class start
    private int id;
    private String title;
    private int stock;
}// class end
