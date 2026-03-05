package study.day06;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data@Builder
public class GoodsDto {


    private Integer gno;
    private String gname;
    private Integer gprice;
    private String gdesc;
    // baseTime
    private String crateDate;
    private String updateDate;



   // ** Dto --> ENTITIY 변환 홤수
    public GoodsEntity toEntitiy(){
        // 필더 패턴이란? new 생성자가 아닌 함수로 객체 생성
        // this이란? 해당 매소드/함수 실행한 객체
        return GoodsEntity.builder() // 빌더 시작
                //여기서는 생략가능
                .gno(this.gno)
                .gname(this.gname)
                .gprice(this.gprice)
                .gdesc(this.gdesc)
                .build(); // 빌더 끝
    }


}
