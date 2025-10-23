package example.종합.실습3; // 패키지명

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper { // interface start
    // [1] 대출
    // 1-1
    @Insert( "insert into rentals(id , book_id , member) values( #{id} , #{book_id} , #{member} )" )
    public boolean bookRent(RentalsDto dto);
    // 1-2
    @Update( "update books set stock = stock - 1 where id = #{id} and stock > 0" )
    public boolean bookMinus(int id);

    // [2] 반납
    // 2-1
    @Update( "update books set stock = stock + 1 where id = #{id} " )
    public boolean bookPlus(int id);
    // 2-2
    @Update( "update rentals set return_date = #{return_date} where return_date IS NULL and book_id = #{book_id} and member = #{member}")
    public boolean bookReturn(RentalsDto dto);
}// interface end
