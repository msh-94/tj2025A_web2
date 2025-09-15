package example.day06;// 패키지명

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class StudentDto {
    private int sno;
    private String name;
    private int kor;
    private int math;
}
