package study.day12.웹크롤링;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

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