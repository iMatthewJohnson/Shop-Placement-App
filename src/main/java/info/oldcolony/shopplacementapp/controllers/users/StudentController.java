package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/users/students") // All api request paths will be relative "/api/v1/users/students"
public class StudentController extends MainController {

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable Integer id) {
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
    //TODO: Add multiple students by feeding in array of students
    @DeleteMapping(path = "/{id}")
    public void removeStudent(@PathVariable Integer id) {
        shopPlacementModel.removeStudent(id);
    }

    //TODO: Remove multiple students by feeding in array of student ids.

    @PatchMapping(path = "/{id}")
    public void updateStudent(@PathVariable Integer id,
                              @RequestParam (value = "firstName", defaultValue = "") String firstName,
                              @RequestParam (value = "lastName", defaultValue = "") String lastName,
                              @RequestParam (value = "idOfEnrolledShop", defaultValue = "-1") String idOfEnrolledShop,
                              @RequestParam (value = "exploratoryGrade", defaultValue = "0.0") String exploratoryGrade) {
        //TODO: Add "IDs of Shop Choices" as RequestParam
        Optional<Student> student = shopPlacementModel.getStudentById(id);
        if (student.isPresent()) {
            if (!firstName.equals("")) student.get().setFirstName(firstName);
            if (!lastName.equals("")) student.get().setLastName(lastName);
            if (!idOfEnrolledShop.equals("-1")) student.get().setIdOfEnrolledShop(Integer.parseInt(idOfEnrolledShop));
            if (!exploratoryGrade.equals("0.0")) student.get().setExploratoryGrade(Double.parseDouble(exploratoryGrade));
            shopPlacementModel.updateStudent(student.get());
        }
    }

    //TODO: Add update multiple students
}
