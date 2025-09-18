package example.종합.예제13.model.dto; // 패키지명

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto { // class start
    private int tno;
    private String tname;
    private String tphone;
    private int tage;
}// class end
