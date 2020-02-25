package local.test.springboot.springdatajpa.repository;

import local.test.springboot.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
