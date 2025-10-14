package example.종합.실습4;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper { // class start
    // 책 단일 등록
    int bookAdd(BookDto dto);
    // 대출 기록 검색
    List<RentalsDto> rentalPrint(String member);
    // 책 일괄등록
    int bookAllAdd(List<BookDto> list);
}// class end
