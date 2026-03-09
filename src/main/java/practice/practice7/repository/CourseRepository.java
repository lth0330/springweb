package practice.practice7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.practice7.Entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
