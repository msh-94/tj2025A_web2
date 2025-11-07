package example2.종합.실습4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @Entity
@Table( name = "todo" )
@NoArgsConstructor @AllArgsConstructor
public class TodoEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private String title;
    private String content;

    public TodoDto toDto(){
        return TodoDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }

}// class end
