package laboratory_tracking.Controller;

import laboratory_tracking.Model.Assignment;
import laboratory_tracking.Service.AssignmentService;
import laboratory_tracking.Service.LaboratoryService;
import laboratory_tracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private LaboratoryService laboratoryService;

    @RequestMapping("/{email}/{password}/laboratories/{lab_id}/assignments")
    public List<String> getAllAssignments(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id) {
        int checkUser = userService.checkUser(email, password);
        if (checkUser != 1 && checkUser != 2) {
            return Collections.singletonList("Login failed. You need a valid account to access this resource.");
        }
        return assignmentService.getAllAssignments(lab_id);
    }

    @RequestMapping("/{email}/{password}/laboratories/{lab_id}/assignments/{id}")
    public String getAssignment(@PathVariable String email, @PathVariable String password, @PathVariable int id) {
        int checkUser = userService.checkUser(email, password);
        if (checkUser != 1 && checkUser != 2) {
            return "Login failed. You need a valid account to access this resource.";
        }
        return assignmentService.getAssignment(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{email}/{password}/laboratories/{lab_id}/assignments")
    public String addAssignment(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id, @RequestBody Assignment assignment) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        assignment.setLaboratory(laboratoryService.getLaboratory(lab_id));
        assignmentService.addAssignment(assignment);
        return "Assignment added successfully.";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{email}/{password}/laboratories/{lab_id}/assignments/{id}")
    public String updateAssignment(@PathVariable String email, @PathVariable String password, @PathVariable int lab_id, @RequestBody Assignment assignment, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        assignment.setLaboratory(laboratoryService.getLaboratory(lab_id));
        assignmentService.updateAssignment(id, assignment);
        return "Assignment updated successfully.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{email}/{password}/laboratories/{lab_id}/assignments/{id}")
    public String deleteAssignment(@PathVariable String email, @PathVariable String password, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        assignmentService.deleteAssignment(id);
        return "Assignment deleted successfully.";
    }
}
