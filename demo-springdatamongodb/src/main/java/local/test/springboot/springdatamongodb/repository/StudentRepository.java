package local.test.springboot.springdatamongodb.repository;

import local.test.springboot.springdatamongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {


}
