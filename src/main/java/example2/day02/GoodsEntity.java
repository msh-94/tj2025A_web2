package example2.day02;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 해당 클래스를 데이터베이스 테이블 과 매핑
@Table( name = "goods" ) // 테이블 이름 정의 , 생략시 클래스명으로 테이블명 정의
@Data @Builder @NoArgsConstructor@AllArgsConstructor // 롬복
public class GoodsEntity extends BaseTime {

    @Id // JPA는 엔티티 1개당 PK필드는 1개이상 필수이다
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 주입 :: MYSQL 만 가능
    private int gno;        // 제품번호     , 자바 int --> DB int

    @Column( nullable = false , length = 100 ) // @Column( 속성명 = 값 , 속성명 = 값 ) ,
    // nullable = false : null 제외 ,
    // length = 100 : 최대 글자수
    private String gname;   // 제품명      , 자바 String --> DB varchar(255)

    @Column( nullable = true ) // null 포함
    private int gprice;     // 제품가격

    @Column( columnDefinition = "varchar(100) default '제품설명' not null" )
    // columnDefinition = "SQL 구문 직접 작석"
    private String gdesc;   // 제품설명

    // ++++++ ENTITY --> DTO ++++++
    // ++ Service -> Controller ++ : R(출력)
    public GoodsDto toDto(){
        // 객체생성방법1 : new 클래스명( 값 , 값 );
        // 객체생성방법2 : 클래스명.builder().속성명(값).속성명(값).build()
        return GoodsDto.builder()
                .gno( this.gno )        // this이란? 현재 메소드를 호출한 인스턴스(객체)
                .gname( this.gname )
                .gprice( this.gprice )
                .gdesc( this.gdesc )
                .create_date( this.getCreateDate().toString() )
                .update_date( this.getUpdateDate().toString() )
                .build();
    } // f end

}// class end
