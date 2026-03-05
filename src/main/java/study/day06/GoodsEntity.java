package study.day06;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity //+영속성
@Table(name="goods")    // 생략시 클래스명으로 자동생성
public class GoodsEntity extends BaseTime{

    @Id     // JPA는 앤티티내 1개 이상의 primary key을 필수로 한다.
    @GeneratedValue(strategy =GenerationType.IDENTITY)  // auto_increment
    private Integer gno;

    @Column(name="제품명", nullable = false, length = 100)
    private String gname;

    // @Column 생략시 : 자바의 타입 --> SQL 타입, 자바의 변수명 --> SQL 필드명
    private Integer gprice;

    @Column(columnDefinition = "varchar(100) default '기본설명' not null")
    private String gdesc;

    // ** ENTITIY --> Dto 변환 홤수
    public GoodsDto toDto(){
        return GoodsDto.builder()  // 빌더 시작
                .gno(gno)
                .gname(gname)
                .gprice(gprice)
                .gdesc(gdesc)
                .crateDate(getCreateDate().toString())  // toString은 날짜가 문자열형식으로 됨, .format을 쓰면 날짜 형식 조정가능
                .updateDate(getUpdateDate().toString())
                .build(); // 빌더 끝
    }



}

/*
    @Id     // JPA는 앤티티내 1개 이상의 primary key을 필수로 한다.
    @GeneratedValue(strategy =GenerationType.IDENTITY)  // auto_increment

     @Column
        (name="필드명"          // 기본값은 자바 필드명
         nullable = false,     // 기본값 true, not null
         length = 길이          // 기본값255, varchar(길이)
         unique = true         // 기본값은 false, 중복여부
         insertable = true     // 기본값은 true, insert 할 때 적용여부
         updatable = true      // 기본값은 true, update할 때 적용여부
         columnDefinition = "SQL"
         )
         레코드 생성(회원가입/등록일/등록일/주문일 등등) 날짜 / 수정 날짜 ** 작성일 자동 등록


*/