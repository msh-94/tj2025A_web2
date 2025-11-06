package example2.종합.실습3;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @Builder
@Table( name = "course" )
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int courseId; // 과정번호
    private String courseName; // 과정명

    @OneToMany( mappedBy = "courseEntity" )
    @Builder.Default
    @ToString.Exclude
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

}// class end
