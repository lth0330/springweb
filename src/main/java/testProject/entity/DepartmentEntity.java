package testProject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testProject.Dto.DepartmentDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dno;

    @Column(unique = true, nullable = false)
    private String dName;

    public DepartmentDto toDto(){
       return DepartmentDto.builder()
                .dno(dno)
                .dName(dName)
                .build();
    }
}
