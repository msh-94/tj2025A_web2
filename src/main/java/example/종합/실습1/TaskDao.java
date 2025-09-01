package example.종합.실습1;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDao { // class start
    // * DB 연동에 필요한 정보
    private String DB_URL = "jdbc:mysql://localhost:3306/springweb2";
    private String DB_USER = "root";
    private String DB_PASSWORD = "1234";
    public Connection conn;         // 하위클래스에서 사용할 수 있게 public으로 선언
    // * DB 연동 생성자
    private TaskDao(){ DBConnect(); }
    // * DB 연동 메소드
    private void DBConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD );
            System.out.println("Dao.DBConnect");
        }catch( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end

    // [1] 30초 마다 모든 제품의 재고는 3개씩 감소
    public void deleteProduct(){
        try{
            String sql = "update products set stock_quantity = stock_quantity -3";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) { System.out.println(e); }
    }// func end

    // [2] 1분마다 모든제품 정보 조회
    public List<Map<String,String>> getProduct(){
        List<Map<String,String>> list = new ArrayList<>();
        try{
            String sql = "select * from products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Map<String,String> map = new HashMap<>();
                map.put("pid",rs.getString("product_id"));
                map.put("pname",rs.getString("product_name"));
                map.put("stock",rs.getString("stock_quantity"));
                list.add(map);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // [3] 5분마다 재고가 10 이하인 상품의 재고 20개 추가
    public void plusProduct(){
        try{
            String sql = "update products set stock_quantity = stock_quantity +20 where stock_quantity <= 10";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) { System.out.println(e); }
    }// func end

}// class end
