package laboratory_tracking.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import laboratory_tracking.Model.Assignment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

    List<Assignment> findByLaboratoryId(int id);
}
