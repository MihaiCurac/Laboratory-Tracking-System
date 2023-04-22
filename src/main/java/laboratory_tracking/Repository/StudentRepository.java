package laboratory_tracking.Repository;

import laboratory_tracking.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByToken(String token);
}
