package testProject.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testProject.entity.BoardEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {


    private Long bno;
    private String name;
    private String position;
    private String picture;

    private String dName;


    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bno(bno)
                .name(name)
                .position(position)
                .picture(picture).build();
    }
}
