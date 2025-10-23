package example.종합.실습3; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service @RequiredArgsConstructor @Transactional
public class BookService { // class start
    private final BookMapper bookMapper;

    // [1] 대출
    public boolean bookRent( RentalsDto dto ){
        boolean result = bookMapper.bookRent(dto);
        if (result == false)throw new RuntimeException("대출기록 예외발생");
        boolean result2 = bookMapper.bookMinus(dto.getBook_id());
        if (result2 == false)throw  new RuntimeException("재고감소 예외발생");
        if (result && result2) return true;
        return false;
    }// func end

    // [2] 반납
    public boolean bookReturn( RentalsDto dto ){
        String now = String.valueOf(LocalDateTime.now());
        dto.setReturn_date(now);
        boolean result = bookMapper.bookReturn(dto);
        if (result == false) throw new RuntimeException("대출기록 예외발생");
        boolean result2 = bookMapper.bookPlus(dto.getBook_id());
        if (result2 == false) throw new RuntimeException("재고증가 예외발생");
        if (result && result2) return true;
        return false;
    }// func end
}// class end
