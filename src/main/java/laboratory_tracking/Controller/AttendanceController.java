package laboratory_tracking.Controller;

import laboratory_tracking.Model.Attendance;
import laboratory_tracking.Service.AttendanceService;
import laboratory_tracking.Service.LaboratoryService;
import laboratory_tracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private UserService userService;
    @Autowired
    private LaboratoryService laboratoryService;

    @RequestMapping("/{email}/{password}/laboratories/{lab_id}/attendance")
    public String getAttendance(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        return attendanceService.getAttendance(lab_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{email}/{password}/laboratories/{lab_id}/attendance")
    public String addAttendance(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id, @RequestBody Attendance attendance) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        attendance.setLaboratory(laboratoryService.getLaboratory(lab_id));
        attendanceService.addAttendance(attendance);
        return "Attendance added successfully.";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{email}/{password}/laboratories/{lab_id}/attendance")
    public String updateAttendance(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id, @RequestBody Attendance attendance) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        attendance.setLaboratory(laboratoryService.getLaboratory(lab_id));
        attendanceService.updateAttendance(attendance);
        return "Attendance updated successfully.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{email}/{password}/laboratories/{lab_id}/attendance")
    public String deleteAttendance(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        attendanceService.deleteAttendance(lab_id);
        return "Attendance deleted successfully.";
    }

}
