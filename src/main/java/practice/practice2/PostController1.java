package practice.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Component// (1)싱글톤 대신에 스프링컨테이너 빈(객체) 등록
//@Controller // (2) HTTP 기능( GET/POST/PUT/DELETE )
//@ResponseBody// (3) HTTP 응답 Content-Type 자동 설정
@RestController // @Controller(+@Component) + @ResponseBody
@RequestMapping("/practice2/post") // 해당 클래스내 메소드들이 정의하는 URL 공통 (+선택)

    /*
        메소드 이란? 상호작용(주고받는 쌍방향 행동)
            매개변수? 매개(중개)변수(정해져있지않는값) : 메소드가 호출될때 들어오는 값 (인수)
            반환값? 메소드가 종료될때 호출했던곳으로 반환해주는 값 (리턴)
        HTTP 이란? 상호작용( request / response )
            request? 클라이언트가 서버로 부터 요청
            response? 서버가 처리한 결과를 클라이언트에 반환/응답
    */
// request? 클라이언트가 서버로 부터 요청
// response? 서버가 처리한 결과를 클라이언트에 반환/응답
public class PostController1 {

    // 1.
    @PostMapping()
    public boolean write(){
        System.out.println("PostController1.write");
        return true;
    }

    // 2.
    @GetMapping()
    public List<Map<String,Object >> view(){

        List<Map<String ,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pno",1);  map1.put("ptitle","제목1");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("pno",2);  map2.put("ptitle","제목2");

        list.add(map1);
        list.add(map2);
        System.out.println("PostController.view");
        return list;
    }
    // 3.
    @GetMapping("/view")
    public List<Map<String,Object>>allView(){
        List<Map<String,Object>> alllist = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pno",1);
        map1.put("ptitle","제목3");
        alllist.add(map1);
        return alllist;
    }
    // 4.
    @PutMapping()
    public boolean update(){
        System.out.println("PostController1.update");
        return true;
    }
    // 5.
    @DeleteMapping()
    public int delete(){
        System.out.println("PostController1.delete");
    return 5;
    }
}
