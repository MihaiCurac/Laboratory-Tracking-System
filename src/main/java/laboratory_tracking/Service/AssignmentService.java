package laboratory_tracking.Service;

import laboratory_tracking.Model.Assignment;
import laboratory_tracking.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<String> getAllAssignments(int lab_id) {
        List<Assignment> assignments = new ArrayList<>(assignmentRepository.findByLaboratoryId(lab_id));
        List<String> assignmentsString = new ArrayList<>();
        for (Assignment assignment : assignments) {
            assignmentsString.add(assignment.toString());
        }
        return assignmentsString;
    }

    public String getAssignment(int id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return "Assignment with id " + id + " not found";
        }
        return assignment.toString();
    }

    public void addAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    public void updateAssignment(int id, Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    public void deleteAssignment(int id) {
        assignmentRepository.deleteById(id);
    }
}
