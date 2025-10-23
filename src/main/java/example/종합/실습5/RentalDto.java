package example.종합.실습5;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentalDto { // class start
    private int id;
    private int book_id;
    private String member;
    private String rent_date;
    private String return_date;

}// class end
