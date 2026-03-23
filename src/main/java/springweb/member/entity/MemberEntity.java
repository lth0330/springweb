package springweb.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.BaseTime;
import springweb.member.dto.MemberDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "member")
public class MemberEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(nullable = false, unique = true, length = 100)
    private  String mid;

    @Column(nullable = false)
    private String mpwd;

    @Column(nullable = false)
    private String mname;

    // 주로 조회할때 사용
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(mno)
                .mid(mid)
                // .mpwd(mpwd)  왠만하면 패스워드는 밖으로 빼는 경우는 없음
                .mname(mname)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString()).build();
    }
}
