package study.day11.todo.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import study.day11.todo.dto.TodoDto;
import study.day11.todo.entity.TodoEntity;
import study.day11.todo.repository.TodoRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@Transactional // 트랜잭션
public class TodoService {
    private final TodoRepository todoRepository;

    // 1. 전체조회
    public List<TodoDto> findAll() {
        // 1] 모든 엔티티 조회한다.
        List<TodoEntity> entityList = todoRepository.findAll();
        // 2] 모든 엔티티 --> 모든 dto 변환한다.
        List<TodoDto> list4 = entityList
                .stream()
                .map(TodoEntity::toDto) // 중간연산 , 람다식 대신에 메소드레퍼런스API( 미리 정의된 메소드 )
                // 클래스명 :: 메소드명
                .collect(Collectors.toList()); // 최종출력 , List타입
        return list4;
    }

    // 2. 개별 조회
    public TodoDto findById(int id) {
        // 방법2]
        TodoDto todoDto = todoRepository.findById(id)
                //.stream()// 스트림( 데이터들 ) 사용하지 않고 Optional 에서 map 메소드 지원
                .map(TodoEntity::toDto) // 중간 연산
                .orElse(null); // 만약에 조회 결과가 없으면 null
        return todoDto;
    }

    // 3. title 개별 조회
    public TodoDto query1(String title) {
        // * findById 밖에 없으므로 리포지토리에서 findByTitle 만들자.
        // 2-1] 쿼리 메소드 호출
        TodoEntity entity = todoRepository.findByTitle(title);
        // 3-1] 네이티브 쿼리 호출
        TodoEntity entity1 = todoRepository.query1(title);
        return entity1.toDto();
    }

    // 4. title 과 content 개별 조회
    public Map<String, Object> query2(
            String title, String content
    ) {
        // 2-2] 쿼리 메소드 호출
        // return todoRepository.findByTitleAndContent(title,content);
        // 2-3] 네이티브 메소드 호출
        return todoRepository.query2(title, content);
    }

    // 5. title이 포함된 개별 조회
    public List<TodoDto> query3(String title) {
        // 2-3]
        // List<TodoEntity> entityList = todoRepository.findTitleContaining(title);
        // 3-2]
        List<TodoEntity> entityList = todoRepository.query3(title);
        return entityList.stream() // 스트림 시작
                .map(TodoEntity::toDto)// 중간연산, 메소드래퍼런스 API, 앤티티 --> dto 변환
                .collect(Collectors.toList());
    }

    // 6. page 인터페이스이란? 페이지 처리 정보 담는 인터페이스
    public Page<TodoDto> page(int page, int size) {
        // 1] 페이징 옵션 설정한다. pageRequest 구현체 , .of(조회할 페이지번호, 페이지당 개수, 정렬);
        // page -1 : JPA는 페이징번호가 0부터 시작함으로써 1페이지는 0 , 2 페이지는 1, 3페이지는 2
        // Sort.by ( sord.Direction.ASC/DESE, "정렬기준필드명" ) : 'id' 속성명으로 내림차순  // 오름차순, 내림차순
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"));
        // 2] findXXX( pageRequest ) 구현체를 포함한다.  , 반환값은 Page<앤티티>
        Page<TodoEntity> entityPage = todoRepository.findAll(pageRequest); // 전체조회에 대한 페이징 처리
        // page.content : 조회된 앤티티들(list)
        // page.empty : 조회 실패 또는 없으면 true, 있으면 false
        // page.totalElements : 페이징 외 전체 자료 개수 ( 총 게시물)
        // page.totalPages : 전체 페이지 개수
        // 3] Page<앤티티> --> Page<Dto> 변환하기
        return entityPage.map(TodoEntity::toDto);  // map과 레퍼런스 API를 이용한 변환

    }

    // 7. 페이징 처리2
    public Page<TodoDto> page2(String keyword, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"));// 1] 페이징 옵션 (구현체) 만든다.
        // 2] 전체조회인지?? 키워드 조회인지??
        Page<TodoEntity> result;
        if (keyword == null || keyword.isBlank()) { // 만약에 키워드가 비어있으면 전체조회
            result = todoRepository.findAll(pageRequest); // 전체조회 + 페이징 처리
        } else {         // 아니면 키워드 조회
            result = todoRepository.query4(keyword, pageRequest); // 개별조회메소드생성 + 페이징 처리
        }
        return result.map(TodoEntity::toDto);
    } // class end
}
/*
        // 2] 모든 엔티티 --> 모든 dto 변환한다.
            // 방법1]
        List<TodoDto> list1 = new ArrayList<>();
        for( int i = 0 ; i<entityList.size() ; i++ ){
            TodoEntity entity = entityList.get( i );
            list1.add( entity.toDto() );
        }
            // 방법2]
        List<TodoDto> list2 = new ArrayList<>();
        entityList.stream().forEach( entity -> { list2.add( entity.toDto() ); }); // forEach 함수는 반환이 없다
            // 방법3]
        List<TodoDto> list3 = entityList.stream() // 스트림(데이터들 흐름) 시작
                                        .map( entity -> entity.toDto() ) // 중간연산 , 람다식( 함수 정의 )
                                        .collect(Collectors.toList() ); // 최종출력
            // 방법4]
        List<TodoDto> list4 = entityList.stream()
                                        .map( TodoEntity :: toDto ) // 중간연산 , 람다식 대신에 메소드레퍼런스API( 미리 정의된 메소드 )
                                        // 클래스명 :: 메소드명
                                        .collect( Collectors.toList() );



        // 방법1]
        Optional< TodoEntity > optional = todoRepository.findById( id );
        if( optional.isPresent() ){
            TodoDto todoDto = optional.get().toDto();
        }

        // 방법2]
        TodoDto todoDto = todoRepository.findById( id )
                // 스트림( 데이터들 ) 사용하지 않고 Optional 에서 map 메소드 지원
                .map( TodoEntity :: toDto ) // 중간 연산
                .orElse( null ); // 만약에 조회 실패하면 null 반환
*/














