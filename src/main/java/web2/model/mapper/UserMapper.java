package web2.model.mapper;// 패키지명

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import web2.model.dto.UserDto;

@Mapper
public interface UserMapper { // class start
    // [1] 회원가입( PK 반환 )
    @Insert("insert into users( uid,upwd,uname,uphone,urole) values( #{uid},#{upwd},#{uname},#{uphone},#{urole} )")
    @Options(useGeneratedKeys = true , keyProperty = "uno") // insert 성공시 매개변수에 생성된 PK값을 주입한다
    public int singUp(UserDto userDto);

    // [2-1] 로그인
    // @Select("select * from users where uid = #{uid} and upwd = #{upwd}")
    // UserDto login( UserDto userDto);

    // [2-2] 회원 아이디로 계정 정보 조회 + 로그인
    @Select("select * from users where uid = #{uid} ")
    UserDto login( String uid );

    // [3] : 패스워드를 제외한 아이디로 계정 정보 조회
    @Select(" select uno , uid , uname , uphone , urole , udate from users where uid = #{uid}")
    UserDto myInfo( String uid );


}// class end
