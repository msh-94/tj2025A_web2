package example.day04._2웹크롤링; // 패키지명

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrawlingService { // class start

    // 1. 뉴스 크롤링 https://www.karnews.or.kr/
    public List<String> task1(){
        List<String> list = new ArrayList<>();
        try {
            // 1-1 크롤링할 웹페이지 주소
            String URL = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";
            // 1-2 JSOUP 이용한 웹주소의 HTML(문서) 가져오기
            // * Document import org.jsoup.nodes.Document;
            // * Jsoup.connect( 크롤링할주소 ).get(); *일반예외
            Document document = Jsoup.connect(URL).get();
            System.out.println("document = " + document);
            // 1-3 : ***************** 가져올 HTML 식별자 .select("CSS선택자"); **********************
            Elements aList = document.select(".titles > a"); // 'titles' 이라는 class 명을 가진 마크업 바로 아래 <a> 마크업
            System.out.println("aList = " + aList);
            // 1-4 : 가져온 마크업들을 반복하여 텍스트만 추출 .text()
            for (Element a : aList){
                String title = a.text();
                System.out.println("title = " + title);
                if (title.isBlank()) continue; // 만약 내용이 없으면 다음반복
                list.add(title);
            }// for end
        } catch (Exception e) { System.out.println("e = " + e); }
        return list;
    }// func end

    // 2. 상품 정보 : 예스24 , https://www.yes24.com/robots.txt
    public List<Map<String , String>> task2(){
        List<Map<String,String>> list = new ArrayList<>();
        try{
            for (int page = 1; page < 4; page++) {
                String URL = "https://www.yes24.com/product/category/daybestseller?CategoryNumber=001&pageNumber="+page+"&pageSize=24&type=day";
                Document document = Jsoup.connect(URL).get();
                Elements nameList = document.select(".info_name > .gd_name");
                Elements priceList = document.select(".txt_num > .yes_b");
                Elements imgList = document.select(".img_bdr .lazy");
                for (int i = 0; i < nameList.size(); i++) {
                    String name = nameList.get(i).text(); // i번째 책제목 1개씩 호출
                    String price = priceList.get(i).text(); // i번째 책가격 1개씩 호출
                    String img = imgList.get(i).attr("data-original");
                    Map<String, String> map = new HashMap<>();
                    map.put("name", name);
                    map.put("price", price);
                    map.put("img", img);
                    list.add(map);
                }// for end
            }// for end
        } catch (Exception e) { System.out.println("e = " + e); }
        return list;
    }// func end

    // 3. 다음날씨 정보 https://weather.daum.net/robots.txt *** 동적 페이지 JSOUP 불가능 ***
    public Map<String,String> task3(){
        Map<String,String> map = new HashMap<>();
        try{
            String URL = "https://weather.daum.net/";
            Document document = Jsoup.connect(URL).get();
            System.out.println("document = " + document);
            Elements elements = document.select(".info_weather .num_deg");
            System.out.println("elements = " + elements);
            String weather = elements.text();
            map.put("weather" , weather);
            System.out.println("weather = " + weather);
        } catch (Exception e) { System.out.println("e = " + e); }
        return map;
    }// func end

}// class end
