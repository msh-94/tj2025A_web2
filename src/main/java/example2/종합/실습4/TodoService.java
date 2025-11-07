package example2.종합.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
@Transactional
public class TodoService {
    // [*]
    private final TodoRepository todoRepository;

    // [1] 등록
    public TodoDto createTodo(TodoDto dto){
        TodoEntity entity = todoRepository.save(dto.toEntity());
        return entity.toDto();
    }// func end

    // [2] 전체조회
    public List<TodoDto> getTodoList(){
        List<TodoEntity> entityList = todoRepository.findAll();
        return entityList.stream().map(TodoEntity::toDto).toList();
    }// func end

}// class end
