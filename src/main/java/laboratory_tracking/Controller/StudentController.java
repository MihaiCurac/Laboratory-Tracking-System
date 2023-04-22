package laboratory_tracking.Controller;

import laboratory_tracking.Model.Student;
import laboratory_tracking.Service.StudentService;
import laboratory_tracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/{email}/{password}/students")
    public List<String> getAllStudents(@PathVariable String email, @PathVariable String password) {
        if (userService.checkUser(email, password) != 1) {
            return Collections.singletonList("Login failed. You need a valid teacher account to access this resource.");
        }
        return studentService.getAllStudents();
    }

    @RequestMapping("/{email}/{password}/students/{id}")
    public String getStudent(@PathVariable String email, @PathVariable String password, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{email}/{password}/students")
    public String addStudent(@PathVariable String email, @PathVariable String password, @RequestBody Student student) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        return studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{email}/{password}/students/{id}")
    public String updateStudent(@PathVariable String email, @PathVariable String password, @RequestBody Student student, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        studentService.updateStudent(id, student);
        return "Student updated successfully.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{email}/{password}/students/{id}")
    public String deleteStudent(@PathVariable String email, @PathVariable String password, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        studentService.deleteStudent(id);
        return "Student deleted successfully.";
    }

    @RequestMapping("register/{email}/{password}/{role}/{token}")
    public String registerStudent(@PathVariable String email, @PathVariable String password, @PathVariable String role, @PathVariable String token) {
        int checkStudent = studentService.checkStudent(token);
        if (checkStudent == -1){
            return "Student with token " + token + " not found";
        }
        else if (checkStudent == 0) {
            return "Student with token " + token + " already registered. Please log into your account.";
        }
        studentService.setStudentUser(userService.addUser(email, password, role), token);
        return "Student with given token registered successfully.";
    }

}
