package example.종합.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class BookService {// class start
    private final BookMapper bookMapper;

    // 책 단일 등록
    public int bookAdd(BookDto dto){
        int result = bookMapper.bookAdd(dto);
        if (result == 1){
            int bno = dto.getId();
            return bno;
        }// if end
        return result;
    }// func end

    // 대출 기록 조회
    public List<RentalsDto> rentalPrint( String title ){
        return bookMapper.rentalPrint(title);
    }// func end

    // 책 일괄 등록
    public List<Integer> bookAllAdd(List<BookDto> list){

    }
}// class end
