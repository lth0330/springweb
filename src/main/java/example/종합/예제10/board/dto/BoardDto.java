package example.종합.예제10.board.dto;


import example.종합.예제10.board.entity.BoardEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {

    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;

    private String createDate;
    private String updateDate;


    // Dto --> entity 변함함수
    public BoardEntity toEntity(){
        return BoardEntity.builder().     // bno,createDate,updateDate는 자동이라 생략가능
                btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter).build();
    }
}
