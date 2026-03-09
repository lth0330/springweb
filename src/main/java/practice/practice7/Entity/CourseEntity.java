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
@Table(name = "course")
public class CourseEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String  courseName;

    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();


}
