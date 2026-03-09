package study.day07.연관관계;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table (name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer rno;
    private String rcontent;

    // CascadeType.ALL이 대표적이로 모든것을 포괄하고 있기 때문에 편하다. ( 힌쪽이 바뀌면 다른쪽도 바뀐다.)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // FK 제약조건 설정

    @JoinColumn(name = "bno")   // FK 필드명 설정
    private BoardEntity boardEntity;

}
/*
    - 영속성이란? 자바객체 와 데이터베이스 데이터 간 매핑/연결 상태
        - 영속성 해제란? 자바객체와 데이터베이스 데이터간 매핑/연결 해제

    - cascade 속성이란? PK와 FK 제약조건 옵션
        CascadeType.ALL : 부모와 삭제/수정/저장이 되면 자식도 같이 삭제/수정/저장이 반영된다.
        CascadeType.REMOVE : 부모가 삭제되면 자식도 같이 삭제 반영된다.
        CascadeType.MERGE : 부모가 수정되면 자식도 같이 수정 반영된다.
        CascadeType.DETCH : 부모가 영속해제되면 자식도 같이 영속 해제 된다.
        CascadeType.REFRESH : 부모가 재호출(갱신)되면 자식도 같이 재호출(갱신)된다.
        CascadeType.PERSIST : 부모가 저장되면 자식도 같이 저장된다.

    - FETCH : 부모[PK] 조회시 자식[FK]관계에서 앤티티 조회여부 선택
        FetchType.EAGER : (기본값) 해당 앤티티 조회시 참조 앤티티 모두 즉시 조회한다.
            - 특징 : 초기 로딩이 느리다, 재사용시 빠르다, *불필요한 정보까지 있을경우 성능 저하*
        FetchType.LAZY  :  해당 앤티티 조회시 참조 앤티티는 조회하지 않는다. < 참조 앤티티 호출시 조회 >
            - 특징 : 초기 호딩이 빠르고 , 재사용성 느리다.   * 필요한 정보만 호출하기 때문에 적절하게 사용가능 < 지연 로딩 >


    - 단방향 / 양방향 활용
        - 만약에 1번 카테고리에 게시물을 등록 한다면, ** fk 필드에 fk 값이 아닌 fk 앤티티를 대입한다.

            Board saveEntity = new BoardEntity();
            saveEntity.setCategory(1) ; [X]

            Category category = repository.findById(1).get();
            saveEntity.setCategory(category); [O]
            repository.save(saveEntity);

        - 만약에 3번 게시물에 댓글을 등록한다면,
            ReplyEntity saveEntity = new RelyEntity();
                BoardEntity board = repository.FindById(3).get();
                saveEntity.setBoardEntity(board)
                repository.save(saveEntity)

 */
