package study.day12.웹크롤링;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrawlingService {

    public List<String> test1(){
        List<String> list = new ArrayList<>();

        // 1) 크롤링 URL 웹페이지 주소
        String url = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";

        // 2) 크롤링 할 URL 요청하여 HTML 전체를 가져온다. Jsoup.connect( 주소 ) .get)_:
        // Document, import org.jsoup.nodes.Document;
        try {
            Document document = Jsoup.connect( url ).get(); // 외부 통신은 일반예외가 주로 발생

            // 3) 특정한 마크업/요소 식별자 , document.select( "식별자" );
            Elements elements = document.select( ".titles > a" ); // 클래스가 titles 인 마크업 아래에 <a> 가져온다.

            // 4) 여러개 가져 왔다면 반복문 이용한 요소/마크업(Element) 1개씩 순회
            for( Element element : elements ){
                // vs innerHTML  비슷하게 마크업 사이 텍스트를 반환 <a> 여기! </a>
                String title = element.text();
                // 만약에 텍스트가 존재하면 리스트에 담기
                if( title.isBlank() ){ continue; } // 반복문 으로 (위로)이동  vs break;
                else{ list.add( title ); }
            }
        }catch ( Exception e ){System.out.println(e);}
      return list;

    }
    // [2] Jsoup을 이용한
    public List<Map<String,Object>> test2(){
        List<Map<String,Object>> list = new ArrayList<>();

        try{
            for (int page = 1; page<=3; page++){


            // 1) 크롤링 URL 주소
            String url = "https://www.yes24.com/product/category/daybestseller";
            url += "?categoryNumber=001"; // 베스트셀러 카테고리 번호
            url += "&pageNumber="+page; // 클롤링할 페이지 번호
            url += "&pageSize=24";  // 페이지당 제품수

            // 2) URL 연결
            Document document = Jsoup.connect( url ).get();

            // 3) 식별자 , 가져올 텍스트가 위치한 식별자와 상위 식별자 1 ~ 2 개를 같이 선택한다 < 중복 배제 >
                Elements nameList = document.select(".info_name .gd_name"); // 책 이름 : info_name .gd_name
                Elements priceList = document.select(".info_price .txt_num .yes_b");// 책 가격 : info_price txt_num .yes_b
                Elements imageList = document.select(".img_bdr .lazy");// 책 이미지 : .img_bdr .lazy

                // 4) 반복문을 이용하여 여러개의 요소/마크업들을 도서별 MAP 구성하여 LIST 저장
                for (int index=0; index< nameList.size(); index++) {
                    // text() : 마크업 사이 텍스트 반환 , attr( 속성명 ) : 해당 속성명의 속성값
                    String name = nameList.get(index).text();
                    String price = priceList.get(index).text();
                    String image = imageList.get(index).attr("data-original");

                    // 5) DTO/MAP 구성
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("price", price);
                    map.put("image", image);
                    System.out.println(map);

                    // 6) 리스트에 맵 넣기
                    list.add(map);
                    System.out.println(list);
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
}

    /*
    - 웹크롤링 : 웹(페이지의) HTML 정보/ 자료 수집 과정
    - 웹페이지 마다 크롤링 허용 여부 : URL?robots.txt
            https://www.jobkorea.co.kr/robots.txt
    - 정적페이지 : HTML , 동적페이지 : JS( AXIOS / REACT )
        - 정적페이지 : Jsoup 라이브러리
        - 동적페이지 : Selenium 라이브러리( * 파이썬과 동일 * )
        Jsoup 라이브러리 : implementation 'org.jsoup:jsoup:1.22.1'
     */