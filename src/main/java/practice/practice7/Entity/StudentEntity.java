package practice.practice7.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;
import practice.practice7.BaseTime;
import practice.practice7.Dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "student")
public class StudentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;

    @OneToMany(mappedBy = "studentEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

    public StudentDto toDto(){
        return StudentDto.builder().
                studentId(studentId)
                .studentName(studentName)
                .crateDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
