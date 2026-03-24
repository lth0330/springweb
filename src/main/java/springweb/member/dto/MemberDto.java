package springweb.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.member.entity.MemberEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDto {

    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;

    // + BaseTime 맴버변수
    private String createDate;
    private String updateDate;

    // 주로 저장이나 수정일때 사용
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(mno)
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .build();
    }
}
