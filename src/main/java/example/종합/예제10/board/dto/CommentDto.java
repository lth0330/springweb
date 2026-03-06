package example.종합.예제10.board.dto;


import example.종합.예제10.board.entity.CommentEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CommentDto {
    private Integer cno;
    private String ccontent;
    private String cwriter;
    private Integer bno;

    private String createDate;
    private String updateDate;


    public CommentEntity toEntity(){
        return CommentEntity.builder()
                .cno(cno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                .bno(bno).build();
    }
}
