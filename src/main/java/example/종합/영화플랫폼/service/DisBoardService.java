package example.종합.영화플랫폼.service; // 패키지명

import example.종합.영화플랫폼.model.dto.DisBoardDto;
import example.종합.영화플랫폼.model.mapper.DisBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class DisBoardService { // class start
    // [*]
    private final DisBoardMapper disBoardMapper;

    // [1] 등록
    public boolean disBoardAdd(DisBoardDto dto){
        boolean result = disBoardMapper.disBoardAdd(dto);
        return result;
    }// func end

    // [2] 삭제
    public boolean disBoardDelete(int mno , int dpwd){
        boolean result = disBoardMapper.disBoardDelete(mno , dpwd);
        return result;
    }// func end

    // [3] 개별조회
    public List<DisBoardDto> disBoardPrint(int mno){
        List<DisBoardDto> result = disBoardMapper.disBoardPrint(mno);
        return result;
    }// func end
}// class end
