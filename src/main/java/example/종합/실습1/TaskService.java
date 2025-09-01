package example.종합.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskService {// class start
    // [*] dao 불러오기
    private final TaskDao taskDao;

    // [1] 매 30초마다 모든 제품의 재고 3개씩 감소
    @Scheduled(cron = "0/30 * * * * *")
    public void deleteProduct(){
        System.out.println("모든제품 3개 감소");
        taskDao.deleteProduct();
    }// func end

    // [2] 매 1분마다 모든 제품 정보를 조회/출력 한다
    @Scheduled(cron = "0 0/1 * * * *")
    public void getProduct(){
        List<Map<String,String>> list = taskDao.getProduct();
        System.out.println(list);
    }// func end

    // [3] 매 5분마다 재고가 10 이하인 상품의 재고를 20개 추가
    @Scheduled( cron = "0 0/5 * * * * ")
    public void plusProduct(){
        taskDao.plusProduct();
        System.out.println("재고가 10이하인 제품 추가");
    }// func end

}// class end
