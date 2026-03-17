package study.day11.todo.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.day11.todo.dto.TodoDto;
import study.day11.todo.entity.TodoEntity;
import study.day11.todo.repository.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@Transactional // 트랜잭션
public class TodoService {
    private final TodoRepository todoRepository;

    // 1. 전체조회
    public List<TodoDto> findAll(){
        // 1] 모든 엔티티 조회한다.
        List<TodoEntity> entityList = todoRepository.findAll();
        // 2] 모든 엔티티 --> 모든 dto 변환한다.
        List<TodoDto> list4 = entityList
                .stream()
                .map( TodoEntity :: toDto ) // 중간연산 , 람다식 대신에 메소드레퍼런스API( 미리 정의된 메소드 )
                // 클래스명 :: 메소드명
                .collect( Collectors.toList() ); // 최종출력 , List타입
        return list4;
    }

    // 2. 개별 조회
    public TodoDto findById( int id ){
        // 방법2]
        TodoDto todoDto = todoRepository.findById( id )
                 //.stream()// 스트림( 데이터들 ) 사용하지 않고 Optional 에서 map 메소드 지원
                .map( TodoEntity :: toDto ) // 중간 연산
                .orElse( null ); // 만약에 조회 결과가 없으면 null
        return todoDto;
    }
    // 3. title 개별 조회
    public TodoDto query1( String title ){
        // * findById 밖에 없으므로 리포지토리에서 findByTitle 만들자.
        // 2-1] 쿼리 메소드 호출
        TodoEntity entity = todoRepository.findByTitle( title );
        // 3-1] 네이티브 쿼리 호출
        TodoEntity entity1 = todoRepository.query1( title );
        return entity1.toDto();
    }

} // class end

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














