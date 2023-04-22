package laboratory_tracking.Service;

import laboratory_tracking.Model.Attendance;
import laboratory_tracking.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public String getAttendance(int lab_id) {
        Attendance attendance = attendanceRepository.findByLaboratoryId(lab_id);
        if (attendance == null) {
            return "Attendance for laboratory with id " + lab_id + " not found";
        }
        return attendance.toString();
    }

    public void addAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    public void updateAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    public void deleteAttendance(int lab_id) {
        Attendance attendance = attendanceRepository.findByLaboratoryId(lab_id);
        attendanceRepository.delete(attendance);
    }
}
