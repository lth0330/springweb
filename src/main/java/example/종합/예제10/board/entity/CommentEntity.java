package example.종합.예제10.board.entity;

import example.종합.예제10.board.BaseTime;
import example.종합.예제10.board.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="comment")
public class CommentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;

    @Column(nullable = false)
    private String ccontent;

    @Column(nullable = false)
    private String cwriter;

    @Column(nullable = false)
    private Integer bno;

    public CommentDto toDto(){
        return CommentDto.builder()
                .cno(cno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .bno(bno).build();
    }
}
