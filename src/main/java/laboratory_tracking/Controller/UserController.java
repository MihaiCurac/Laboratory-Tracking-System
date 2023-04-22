package laboratory_tracking.Controller;

import laboratory_tracking.Model.Laboratory;
import laboratory_tracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("{email}/{password}")
    public String logIn(@PathVariable String email, @PathVariable String password) {
        int checkUser = userService.checkUser(email, password);
        if (checkUser == 1) {
            return "Successful login into teacher account.";
        }
        else if (checkUser == 2) {
            return "Successful login into student account.";
        }
        else {
            return "Login failed. Please check your credentials.";
        }
    }
}
