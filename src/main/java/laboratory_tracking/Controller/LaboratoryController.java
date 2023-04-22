package laboratory_tracking.Controller;

import laboratory_tracking.Model.Laboratory;
import laboratory_tracking.Service.LaboratoryService;
import laboratory_tracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private UserService userService;

    @RequestMapping("/{email}/{password}/laboratories")
    public List<String> getAllLaboratories(@PathVariable String email, @PathVariable String password) {
        int checkUser = userService.checkUser(email, password);
        if (checkUser != 1 && checkUser != 2) {
            return Collections.singletonList("Login failed. You need a valid account to access this resource.");
        }
        return laboratoryService.getAllLaboratories();
    }

    @RequestMapping("/{email}/{password}/laboratories/{id}")
    public String getLaboratory(@PathVariable String email, @PathVariable String password,@PathVariable int id) {
        int checkUser = userService.checkUser(email, password);
        if (checkUser != 1 && checkUser != 2) {
            return "Login failed. You need a valid account to access this resource.";
        }
        return laboratoryService.getLaboratoryStr(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{email}/{password}/laboratories")
    public String addLaboratory(@PathVariable String email, @PathVariable String password, @RequestBody Laboratory laboratory) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        laboratoryService.addLaboratory(laboratory);
        return "Laboratory added successfully.";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{email}/{password}/laboratories/{id}")
    public String updateLaboratory(@PathVariable String email, @PathVariable String password, @RequestBody Laboratory laboratory, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        laboratoryService.updateLaboratory(id, laboratory);
        return "Laboratory updated successfully.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{email}/{password}/laboratories/{id}")
    public String deleteLaboratory(@PathVariable String email, @PathVariable String password, @PathVariable int id) {
        if (userService.checkUser(email, password) != 1) {
            return "Login failed. You need a valid teacher account to access this resource.";
        }
        laboratoryService.deleteLaboratory(id);
        return "Laboratory deleted successfully.";
    }
}
