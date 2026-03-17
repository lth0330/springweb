package study.day11.todo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.day11.todo.entity.TodoEntity;

@Repository
public interface TodoRepository
        extends JpaRepository<TodoEntity,Integer> {
    // 1] JpaRepository 로부터 상속받으면 .save(),find(),delete() 등등 제공받는다.
    // * findAll( ) : 전체조회 , findById( pk값 ) : 식별자1개조회  등등 그외 없으면 만들기

    // ================================== 그외 만들기 ==========================
    // 2] 쿼리 메소드 : SQL 직접 작성하지 않고 추상메소드 이름으로 쿼리 자동 생성 < 카멜 표기법 >
    // 2-1 : title 으로 조회 , 엔티티타입명 findBy필드명( 타입 매개변수 );
    TodoEntity findByTitle( String title ); // 추상메소드란? { } 구현부가없는 메소드

    // 3] 네이티브 메소드
    // 3-1 : 연동된 데이터베이스 쿼리 사용 가능하다.
    // @Query( value = "SQL" , nativeQuery = true );
    // select * from todo where title = :매개변수명; // 매개변수명 앞에 :(콜론) 이용하여 매개변수값 대입
    @Query( value = "select * from todo where title = :title" , nativeQuery = true)
    TodoEntity query1( String title );

    // 4] JPQL

} // class end







