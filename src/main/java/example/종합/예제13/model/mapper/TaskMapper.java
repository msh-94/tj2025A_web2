package example.종합.예제13.model.mapper; // 패키지명

import example.종합.예제13.model.dto.TaskDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper { // class start
    // [1] 등록
    @Insert("insert into task(tname,tphone,tage) values(#{tname} , #{tphone} , #{tage})")
    boolean taskAdd(TaskDto taskDto);

    // [2] 전체조회
    @Select("select * from task")
    List<TaskDto> taskPrint();

    // [3] 삭제
    @Delete("delete from task where tno = #{tno}")
    boolean taskDelete(int tno);
}// class end
