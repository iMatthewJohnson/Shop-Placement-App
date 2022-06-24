package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.cruds.Shop;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/users/students") // All api request paths will be relative "/api/v1/users/students"
public class StudentController extends MainController {

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable int id) {
        Optional<Student> student = shopPlacementModel.getStudentById(id);
        //TODO: check if present
        return student.get();
    }

    @PostMapping()
    public void addStudent(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        Student newStudent = new Student(id, firstName, lastName);
        shopPlacementModel.add(newStudent);
    }
}
