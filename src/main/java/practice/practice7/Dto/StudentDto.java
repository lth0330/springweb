package practice.practice7.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.Entity.StudentEntity;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {

    private Integer studentId;
    private String studentName;
    private String crateDate;
    private String updateDate;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
                .studentId(studentId)
                .studentName(studentName)
                .enrollEntityList(new ArrayList<>()) //@Builder.Default을 앤티티에 넣어놔서 아에 여기줄은 삭제해도 됨
                .build();
    }
}
