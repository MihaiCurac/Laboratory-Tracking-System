package laboratory_tracking.Service;

import laboratory_tracking.Model.User;
import laboratory_tracking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public int checkUser(String email, String password) {
        User user = getUserByEmail(email);
        if (user == null) {
            return -1;
        }
        if (user.getPassword().equals(encodePassword(password))) {
            if(user.getRole().equals("teacher")){
                return 1;
            }
            else if(user.getRole().equals("student")){
                return 2;
            }
        }
        return 0;
    }

    public User addUser(String email, String password, String role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(encodePassword(password));
        user.setRole(role);
        userRepository.save(user);
        return user;
    }
}
