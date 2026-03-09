package practice.practice7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.practice7.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
