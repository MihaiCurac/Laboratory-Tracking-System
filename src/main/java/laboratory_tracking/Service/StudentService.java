package laboratory_tracking.Service;

import laboratory_tracking.Model.Student;
import laboratory_tracking.Model.User;
import laboratory_tracking.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<String> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        List<String> studentsString = new ArrayList<>();
        for (Student student : students) {
            studentsString.add(student.toString());
        }
        return studentsString;
    }

    public String getStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return "Student with id " + id + " not found";
        }
        return student.toString();
    }

    public Student getStudentByToken(String token) {
        return studentRepository.findByToken(token);
    }

    public int checkStudent(String token) {
        Student student = getStudentByToken(token);
        if (student == null) {
            return -1;
        }
        if (student.getUser() != null) {
            return 0;
        }
        return 1;
    }

    public void setStudentUser(User user, String token) {
        Student student = getStudentByToken(token);
        student.setUser(user);
        studentRepository.save(student);
    }

    public String addStudent(Student student) {
        Random random = new Random();
        String token = random.ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(128)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        student.setToken(token);
        studentRepository.save(student);
        return "Student added successfully with token: " + token;
    }

    public void updateStudent(int id, Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

}
