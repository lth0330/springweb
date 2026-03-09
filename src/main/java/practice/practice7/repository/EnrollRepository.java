package practice.practice7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.practice7.Entity.EnrollEntity;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer> {
}
