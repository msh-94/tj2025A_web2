package example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
@Transactional
public class GoodsService {

    private final GoodsRepository goodsRepository;

    // [1] 등록
    public GoodsDto save(GoodsDto dto){
        GoodsEntity entity = dto.toEntity();
        GoodsEntity saveEntity = goodsRepository.save(entity);
        return saveEntity.toDto();
    }// func end

    // [2] 전체조회
    public List<GoodsDto> findAll(){
        List<GoodsEntity> entityList = goodsRepository.findAll();
        // 방법1 for 문
        //List<GoodsDto> dtoList = new ArrayList<>();
        //for (GoodsEntity entity : entityList){
        //    dtoList.add(entity.toDto());
        //}// for end
        // 방법2 스트림 API
        List<GoodsDto> goodsDtoList = entityList.stream()
                .map( GoodsEntity :: toDto ).collect(Collectors.toList());
        return goodsDtoList;
    }// func end

    // [3] 개별조회
    public GoodsDto find(int gno){
        Optional<GoodsEntity> optional = goodsRepository.findById(gno);
        if (optional.isPresent()){
            GoodsEntity entity = optional.get();
            return entity.toDto();
        }// if end
        return null;
    }// func end

    // [4] 개별삭제
    public boolean delete(int gno){
        goodsRepository.deleteById(gno);
        Optional<GoodsEntity> optional = goodsRepository.findById(gno);
        if (optional.isPresent()){
            return false;
        }// if end
        return true;
    }// func end

    // [5] 개별수정
    public GoodsDto update(GoodsDto dto){
        Optional<GoodsEntity> optional = goodsRepository.findById(dto.getGno());
        if (optional.isPresent()){
            GoodsEntity goodsEntity = optional.get();
            goodsEntity.setGname(dto.getGname());
            goodsEntity.setGdesc(dto.getGdesc());
            goodsEntity.setGdesc(dto.getGdesc());
            return goodsEntity.toDto();
        }else {
            GoodsEntity goodsEntity = goodsRepository.save(dto.toEntity());
            return goodsEntity.toDto();
        }// if end
    }// func end

}// class end
