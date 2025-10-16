package example.종합.실습5; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service @RequiredArgsConstructor
public class BooksService { // class start
    private final BooksMapper booksMapper;

    // [1] books 테이블에 price 가격(int) 추가
    public int priceAdd(){
        return booksMapper.priceAdd();
    }// func end

    // [2] books 테이블에 title 책이름(longtext)로 수정
    public int titleUpdate(){
        return booksMapper.titleUpdate();
    }// func end

    // [3] 평균재고보다 많은 도서 조회
    public List<BooksDto> getBooks(){
        return booksMapper.getBooks();
    }// func end

    // [4] 가장많이 대출한 도서 조회
    public String firstBook(){
        return booksMapper.firstBook();
    }// func end

    // [5] 대출기록 상세 뷰 생성
    public int loanAdd(){
        return booksMapper.loanAdd();
    }// func end

    // [6] 평균 재고보다 많은 재고를 가진 도서 뷰 생성
    public int excellentAdd(){
        return booksMapper.excellentAdd();
    }// func end

    // [7] 대출기록 상세 뷰 조회
    public List<Map<String, Object>> getLoan(){
        return booksMapper.getLoan();
    }// func end

    // [8] 평균 재고보다 많은 재고를 가진 도서 뷰 조회
    public List<BooksDto> getExcellent(){
        return booksMapper.getExcellent();
    }// func end
}// class end
