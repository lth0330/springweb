package study.day07.연관관계;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")
public class BoardEntity {
    // ** 단방향 **  FK 만들기 **
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String bcontent;

    @ManyToOne      // 다수가 하나에게 . M:1  여러개 게시물이 하나의 카테고리에게 참조
    @JoinColumn(name = "cno")   // 관례적으로 fk 필드명도 pk 필드명과 동일
    private CategoryEntity categoryEntity;


    // 양방향
    @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();
}
