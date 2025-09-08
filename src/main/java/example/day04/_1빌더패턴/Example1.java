package example.day04._1빌더패턴; // 패키지명


import lombok.Builder;
import lombok.ToString;

// (2) 설계 클래스
@Builder
@ToString
class MemberDto{
    // 1. 멤버변수
    private String name;
    private int age;
    // 2. 생성자
    MemberDto(){}                       // 2-1 기본 생성자 : @NoArgsConstructor 매개변수가 없는
    MemberDto(String name , int age){
        this.name = name;
        this.age = age;
    } // 2-2 전체생성자 : @AllArgsConstructor 모든 매개변수를 갖는
    // 3. 메소드
}

// (1) 실행 클래스
public class Example1 { // class start
    public static void main(String[] args) { // main start

        // 1. 객체를 생성할때 사용되는 메소드 : new 연산자 뒤로 MemberDto()
        MemberDto m1 = new MemberDto(); // 1-기본생성자
        // 2.
        MemberDto m2 = new MemberDto("유재석" , 40); // 2-생성자
        // 3. ******** 생성자의 규칙 ********
        // 3-1 존재 하지 않는 생성자는 불가능
        // MemberDto m3 = new MemberDto("유재석");

        // 3-2 매개변수의 순서를 바꾸면 안된다
        // MemberDto m4 = new MemberDto(40,"유재석");

        // 즉 : 생성자는 정해진 매개변수에 따라 사용된다 , 유연성 떨어짐

        // 4. ********** 빌더 패턴 **********
        // 즉] 생성자 유무와 상관없이 메소드로 객체 초기화
        MemberDto m5 = MemberDto.builder().build();
        System.out.println("m5 = " + m5); // soutv

        MemberDto m6 = MemberDto.builder().name("유재석").build();
        System.out.println("m6 = " + m6);

        MemberDto m7 = MemberDto.builder().age(40).name("유재석").build();
        System.out.println("m7 = " + m7);

    }// main end
}// class end
