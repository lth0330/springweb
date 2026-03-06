package example.종합.예제10.board.entity;

import example.종합.예제10.board.BaseTime;
import example.종합.예제10.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "board")
public class BoardEntity extends BaseTime {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(length = 255, nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext not null")  //직접 sql 문법으로 설정
    private String bcontent;

    @Column(length = 30, nullable = false)
    private String bwriter;

    // 생성,수정 날짜, 시간은 BaseTime으로 상속받기

    // entity --> Dto 변한함수   ** 주로 조회할때 사용
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
