package practice.practice7.Entity;

import jakarta.persistence.*;
import lombok.*;
import practice.practice7.BaseTime;

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
}
