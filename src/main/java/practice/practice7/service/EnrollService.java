package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Dto.CourseDto;
import practice.practice7.Dto.EnrollDto;
import practice.practice7.Dto.StudentDto;
import practice.practice7.Entity.CourseEntity;
import practice.practice7.Entity.EnrollEntity;

import practice.practice7.Entity.StudentEntity;
import practice.practice7.repository.CourseRepository;
import practice.practice7.repository.EnrollRepository;
import practice.practice7.repository.StudentRepository;

import java.util.Optional;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    // 과정등록
    public boolean 과정등록(CourseDto courseDto) {
        CourseEntity courseEntity = courseDto.toEntity();
        CourseEntity saved = courseRepository.save(courseEntity);

        if (saved.getCourseId() >= 1) return true;
        return false;

    }
    //=========================================================//
    // 학생등록
    public boolean 학생등록(StudentDto studentDto) {
        StudentEntity studentEntity = studentDto.toEntity();
        StudentEntity saved = studentRepository.save(studentEntity);

        if (saved.getStudentId() >= 1) return true;
        return false;
    }
    //=========================================================//
    // 수강등록
    public boolean 수강등록(EnrollDto enrollDto) {

        // 과정
        int courseId = enrollDto.getCourseDto().getCourseId();
        Optional<CourseEntity> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) return true;
        CourseEntity courseEntity = optionalCourse.get();

        // ===========================================//
        // 학생
        int studentId = enrollDto.getStudentDto().getStudentId();
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) return true;
        StudentEntity studentEntity = optionalStudent.get();

        //=========================================================
        EnrollEntity enrollEntity = EnrollEntity.builder()
                .status(enrollDto.getStatus())
                .courseEntity(courseEntity)
                .studentEntity(studentEntity)
                .build();


        EnrollEntity saved = enrollRepository.save(enrollEntity);

        if(saved.getEnrollId() >= 1) return true;
        return false;
    }

    // 수강조회
    public EnrollDto 수강조회(int enrollId){
        Optional<EnrollEntity> optional = enrollRepository.findById(enrollId);

        if(optional.isPresent()){
            EnrollEntity entity = optional.get();
            EnrollDto enrollDto = entity.toDto();
            return enrollDto;
        }
        return null;
    }
}


