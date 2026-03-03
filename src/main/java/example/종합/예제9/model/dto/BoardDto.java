package example.종합.예제9.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor  // 매개변수 없는 생성자 자동 생성
@AllArgsConstructor // 전체 매개변수 자동 생성
@Data
public class  BoardDto {
    private Integer bno;
    private String bcontent;
    private String bwriter;
    private String bdate;

}
