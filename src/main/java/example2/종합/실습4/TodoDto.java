package example2.종합.실습4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
    private int id;
    private String title;
    private String content;

    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }

}// class end
