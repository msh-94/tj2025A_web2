package example2.종합.실습3;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @Builder
@Table( name = "student" )
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int studentId; // 학생번호
    private String studentName; // 학생명

    @OneToMany( mappedBy = "studentEntity" )
    @Builder.Default
    @ToString.Exclude
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

}// class end
