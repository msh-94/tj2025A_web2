package example2.종합.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    // [1] 도서 등록
    public boolean save(BookEntity bookEntity){
        BookEntity saveEntity = bookRepository.save(bookEntity);
        if (saveEntity != null){
            return true;
        }// if end
        return false;
    }// func end

    // [2] 도서 전체 조회
    public List<BookEntity> get(){
        List<BookEntity> list = bookRepository.findAll();
        return list;
    }// func end

    // [3] 특정 도서 수정
    public boolean put(BookEntity bookEntity){
        Optional<BookEntity> optional = bookRepository.findById(bookEntity.getBno());
        if (optional.isPresent()){
            BookEntity entity = optional.get();
            entity.setName(bookEntity.getName());
            entity.setWriter(bookEntity.getWriter());
            entity.setPublisher(bookEntity.getPublisher());
            return true;
        }// if end
        return false;
    }// func end

    // [4] 특정 도서 삭제
    public boolean delete(int bno){
        bookRepository.deleteById(bno);
        Optional<BookEntity> optional = bookRepository.findById(bno);
        if (optional.isPresent())return false;
        return true;
    }// func end

}// class end
