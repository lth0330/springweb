package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Dto.StudentDto;
import practice.practice7.Entity.StudentEntity;
import practice.practice7.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public boolean 학생등록(StudentDto studentDto) {
        StudentEntity studentEntity = studentDto.toEntity();
        StudentEntity saved = studentRepository.save(studentEntity);

        if (saved.getStudentId() >= 1) return true;
        return false;
    }
}
