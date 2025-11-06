package example2.종합.실습3;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity @Data @Builder
@Table( name = "enroll" )
public class EnrollEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int enrollId; // 수강번호
    private String status; // 수강상태

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn( name = "studentId" )
    private StudentEntity studentEntity;

    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JoinColumn( name = "courseId" )
    private CourseEntity courseEntity;

}// class end
