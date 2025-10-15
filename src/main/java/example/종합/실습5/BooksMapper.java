package example.종합.실습5;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksMapper { // interface start
    // [1] books 테이블에 price 가격(int) 추가
    int priceAdd();
    // [2] books 테이블에 title 책이름(longtext)로 수정
    int titleUpdate();
    // [3] 평균재고보다 많은 도서 조회
    List<BooksDto> getBooks();
    // [4] 가장많이 대출한 도서 조회
    String firstBook();
}// interface end
