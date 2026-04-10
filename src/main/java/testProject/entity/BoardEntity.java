package testProject.entity;


import jakarta.persistence.*;
import lombok.*;
import testProject.Dto.BoardDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @ManyToOne
    @JoinColumn(name = "dno") @ToString.Exclude
    private DepartmentEntity departmentEntity;

    private String name;
    private String position;
    private String picture;

    public BoardDto toDto(){
        return BoardDto.builder().bno(bno)
                .name(name)
                .position(position)
                .picture(picture)
                .dName(departmentEntity.getDName()).build();
    }
}
