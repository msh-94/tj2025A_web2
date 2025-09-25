package example.day09; // 패키지명

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TransMapper { // class start
    // (1) insert 정상
    @Insert( "insert into trans( name ) values( #{name} ) " )
    public boolean trans1(String name);
    // (1) insert 비정상
    @Insert( "insert into trans( name ) 오류( #{name} ) " )
    public boolean trans2(String name);

    // (2) Update 입금 , 더하기
    @Update( "update trans set money = money + #{money} where name = #{name} " )
    public boolean deposit( String name , int money );
    // (2) Update 입금 , 빼기
    @Update( "update trans set money = money - #{money} where name = #{name} and money >= #{money}" )
    public boolean withdraw( String name , int money );
}// class end