package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Entity.CourseEntity;
import practice.practice7.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
}
