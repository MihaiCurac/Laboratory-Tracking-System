package laboratory_tracking.Repository;

import laboratory_tracking.Model.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
    Attendance findByLaboratoryId(int lab_id);
}
