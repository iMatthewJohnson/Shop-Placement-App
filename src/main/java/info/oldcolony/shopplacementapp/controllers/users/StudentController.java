package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO: Documentation and testing

@RestController
@RequestMapping(path="/api/v1/users/students") // All api request paths will be relative "/api/v1/users/students"
public class StudentController extends MainController {

    // GET requests

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        Optional<Student> student = shopPlacementModel.getStudentById(id);
        //TODO: check if present
        return student.get();
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Student> getAllStudents() {
        return shopPlacementModel.getAllStudents();
    }

    // POST requests

    @PostMapping()
    public void addStudent(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "idOfEnrolledShop", required = false) Integer idOfEnrolledShop,
                           @RequestParam(value = "exploratoryGrade", required = false) Double exploratoryGrade,
                           @RequestParam(value = "idOfShopChoices", required = false) List<Integer> idsOfShopChoices) {
        Student newStudent = new Student(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade, idsOfShopChoices);
        shopPlacementModel.add(newStudent);
    }

    @PostMapping(consumes = "application/json")
    public void addStudents(@RequestBody List<Student> students) {
        shopPlacementModel.add(students);
    }


    // DELETE requests
    @DeleteMapping(path = "/{id}")
    public void removeStudentById(@PathVariable Integer id) {
        shopPlacementModel.removeStudent(id);
    }

    @DeleteMapping()
    public void removeStudentsByIds(@RequestParam List<Integer> ids) {
        shopPlacementModel.removeStudents(ids);
    }

    // PATCH requests
    @PatchMapping(path = "/{id}")
    public void updateStudent(@PathVariable Integer id,
                              @RequestParam (value = "firstName", required = false) String firstName,
                              @RequestParam (value = "lastName", required = false) String lastName,
                              @RequestParam (value = "idOfEnrolledShop", required = false) Integer idOfEnrolledShop,
                              @RequestParam (value = "exploratoryGrade", required = false) Double exploratoryGrade,
                              @RequestParam (value = "idsOfShopChoices", required = false) List<Integer> idsOfShopChoices) {
        shopPlacementModel.updateStudentWithId(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade,
                idsOfShopChoices);
    }

    @PatchMapping(consumes = "application/json")
    public void updateStudents(@RequestBody List<Student> students) {
        shopPlacementModel.updateStudents(students);
    }
}
