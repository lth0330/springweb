package springweb.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import springweb.board.entity.BoardEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {
    private Long bno;
    private String btitle;
    private String bcontent;
    private String bfile;

    // + Dto 에는 앤티티 정보를 포함하지 않고 필요한 정보만 맴버변수로 구성한다.
    private Long mno;   // 회원번호
    private String mid; // 회원닉네임

    private String createDate;
    private String updateDate;

    // + 첨부파일 매핑    , 여러개 이면 List로 묶기  List<MultipartFile>
    private  MultipartFile uploadFile;   // 업로드 용도

    // + toEntity
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                // .bno() 는 auto이기때문에 생략가능
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                //.memberEntity() fk는 서비스에서 대입
                .build();
    }
}
