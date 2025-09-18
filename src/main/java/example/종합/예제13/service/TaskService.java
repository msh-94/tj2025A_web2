package example.종합.예제13.service; // 패키지명

import example.종합.예제13.model.dto.TaskDto;
import example.종합.예제13.model.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class TaskService { // class start
    private final TaskMapper taskMapper;

    // [1] 등록
    public boolean taskAdd(TaskDto taskDto){
        boolean result = taskMapper.taskAdd(taskDto);
        return result;
    }// func end

    // [2] 전체조회
    public List<TaskDto> taskPrint(){
        List<TaskDto> result = taskMapper.taskPrint();
        return result;
    }// func end

    // [3] 삭제
    public boolean taskDelete(int tno){
        boolean result = taskMapper.taskDelete(tno);
        return result;
    }// func end
}// class end
