package practice.practice7.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.Entity.CourseEntity;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CourseDto {

    private Integer courseId;
    private String  courseName;
    private String crateDate;
    private String updateDate;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .courseId(courseId)
                .courseName(courseName)
                .enrollEntityList(new ArrayList<>())  //@Builder.Default을 앤티티에 넣어놔서 아에 여기줄은 삭제해도 됨
                .build(); //
    }
}
