package springweb.board.entity;

import jakarta.persistence.*;
import lombok.*;
import springweb.BaseTime;
import springweb.board.dto.BoardDto;
import springweb.member.entity.MemberEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "board")
public class BoardEntity extends BaseTime {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false, length = 255)
    private String btitle;

    @Column(nullable = false, columnDefinition = "longtext")
    private String bcontent;

    @Column()   // 주로 첨부파일은 파일 자체를 저장하는게 아니라 파일을 위치(서버내 경로) 저장
    private String bfile;   // 세시물 첨부파일, 만약에 기시물당 첨부파일 여러개이면 앤티티 분리


    // * 단방향 : 한명의 회원이 여러개 게시물 작성한다.  1:N
    @ManyToOne
    @JoinColumn(name = "mno") @ToString.Exclude
    private MemberEntity memberEntity;

    // + Dto
    public BoardDto toDto(){
        return BoardDto.builder().bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                .mno(memberEntity.getMno())
                .mid(memberEntity.getMid())
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString()).build();
    }
}
