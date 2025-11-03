package example2.종합.실습1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookEntity {
    @Id
    int bno;            // 도서번호
    String name;        // 책이름
    String writer;      // 저자
    String publisher;   // 출판사
}// class end
