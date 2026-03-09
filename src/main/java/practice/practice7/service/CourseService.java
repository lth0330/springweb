package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Dto.CourseDto;
import practice.practice7.Entity.CourseEntity;
import practice.practice7.repository.CourseRepository;
import practice.practice7.repository.StudentRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public boolean 과정등록(CourseDto courseDto){
        CourseEntity courseEntity = courseDto.toEntity();
        CourseEntity saved = courseRepository.save(courseEntity);

        if (saved.getCourseId()>=1)return true;
        return false;
    }
}
