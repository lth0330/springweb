package practice.practice7.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.Entity.CourseEntity;
import practice.practice7.Entity.EnrollEntity;
import practice.practice7.Entity.StudentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollDto {

    private Integer enrollId;
    private String status;

    private CourseEntity courseEntity;
    private StudentEntity studentEntity;

    private String crateDate;
    private String updateDate;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
                .enrollId(enrollId)
                .status(status)
                .courseEntity(courseEntity)
                .studentEntity(studentEntity).build();

    }
}
