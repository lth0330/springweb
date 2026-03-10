package practice.practice7.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.BaseTime;
import practice.practice7.Dto.EnrollDto;
import study.day07.연관관계.BoardEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "Enroll")
public class EnrollEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollId;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    public EnrollDto toDto(){
        return EnrollDto.builder()
                .enrollId(enrollId)
                .status(status)
                .courseDto(courseEntity.toDto())
                .studentDto(studentEntity.toDto())
                .crateDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}


