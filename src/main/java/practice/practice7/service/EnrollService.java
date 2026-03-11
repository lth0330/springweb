package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Dto.EnrollDto;
import practice.practice7.Entity.EnrollEntity;

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

    public boolean 수강등록(EnrollDto enrollDto){
        EnrollEntity enrollEntity = enrollDto.toEntity();
        EnrollEntity saved = enrollRepository.save(enrollEntity);
        if(saved.getEnrollId() != null){

        }

        if (saved.getEnrollId()>=1)return true;
        return false;
    }

    public EnrollDto 수강조회(int enrollId){
        Optional<EnrollEntity> optional = enrollRepository.findById(enrollId);

        if (optional.isPresent()){
            EnrollEntity entity = optional.get();
            EnrollDto enrollDto = entity.toDto();

            return enrollDto;
        }
        return null;

    }
}


