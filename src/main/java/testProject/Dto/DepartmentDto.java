package testProject.Dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testProject.entity.DepartmentEntity;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class DepartmentDto {

    private Long dno;

    private String dName;


    public DepartmentEntity toEntity(){
        return DepartmentEntity.builder().
                dName(dName).build();
    }
}
