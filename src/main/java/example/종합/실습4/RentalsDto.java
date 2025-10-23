package example.종합.실습4;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentalsDto { // class start
    private int id;
    private int book_id;
    private String member;
    private String rent_date;
    private String return_date;

}// class end