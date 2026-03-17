package study.day11.todo.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.day11.todo.dto.TodoDto;
import study.day11.todo.service.TodoService;


import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    // 1. 전체조회
    @GetMapping("") // http://localhost:8080/api/todo
    public ResponseEntity< ? > findAll(){
        List<TodoDto> result = todoService.findAll();
        return ResponseEntity.status( 200 ).body( result );
        // HTTP 응답코드 200 또는 ok (성공 의미)
    }

    // 2. 개별조회
    @GetMapping("/detail") // http://localhost:8080/api/todo/detail?id=1
    public ResponseEntity< ? > findById( @RequestParam int id ){
        TodoDto result = todoService.findById( id );
        return ResponseEntity.status( 200 ).body( result );
    }
    // 3. title 개별 조회
    // http://localhost:8080/api/todo/query1?title=자바 공부
    @GetMapping("/query1")
    public ResponseEntity<?> query1(
            @RequestParam String title ){
        TodoDto result = todoService.query1( title );
        return ResponseEntity.ok( result );
    }

    // 4. title 과 content 개별 조회
    @GetMapping("/query2")
    public ResponseEntity<?> query2(
            @RequestParam String title,
            @RequestParam String content
    ){
        Map<String,Object> result = todoService.query2(title,content);
        return ResponseEntity.status(200).body(result);
    }

    // 5. title이 포함된 개별 조회
    @GetMapping("/qurey3")
    public ResponseEntity<?> query3(@RequestParam String title){
        List<TodoDto> result = todoService.query3(title);
        return ResponseEntity.status(200).body(result);
    }

} // class end

// ResponseEntity : 응답객체 , 사용목적 : 반환값 외 추가적인 자료 포함 <응답코드>
    // < > : 제네릭 , < ? > 제네릭에 ? 타입 사용시 Object 와 동일하게 모든 타입을 대입 가능하다.
    // ResponseEntity< Integer >  : Integer 타입만 반환
    // ResponseEntity< ? > : 모든 타입 반환















