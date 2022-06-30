package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.student.Student;
import info.oldcolony.shopplacementapp.model.student.StudentDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller class that handles all HTTP request for the Student resource, including adding, removing,
 * updating, and deleting users from the {@code ShopPlacementModel}
 */
@RestController
@RequestMapping(path="/api/v1/users/students") // All api request paths will be relative "/api/v1/users/students"
public class StudentController extends MainController<Student> {

    @Autowired
    StudentDataModel model;

    //region POST requests

    /**
     * Adds a single student to the application
     * @param id REQUIRED Student's student ID
     * @param firstName REQUIRED Student's first name
     * @param lastName REQUIRED Student's last name
     * @param idOfEnrolledShop OPTIONAL The ID of the Shop student is enrolled in
     * @param exploratoryGrade OPTIONAL Student's exploratory grade
     * @param idsOfShopChoices OPTIONAL List of IDs of the shops the student has selected in order of priority (i.e.
     *                         index 0 is 1st choice, index 1 is second choice, etc)
     */
    @PostMapping
    public void addStudent(@RequestParam Integer id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam (required = false) Integer idOfEnrolledShop,
                           @RequestParam (required = false) Double exploratoryGrade,
                           @RequestParam (required = false) List<Integer> idsOfShopChoices) {
        Student newStudent = new Student(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade, idsOfShopChoices);
        model.add(newStudent);
    }

    //endregion

    //region PATCH requests

    /**
     * Updates a single student's information
     * @param id REQUIRED Student ID of the student being updated
     * @param firstName OPTIONAL Student's updated first name
     * @param lastName OPTIONAL Student's updated last name
     * @param idOfEnrolledShop OPTIONAL Student's updated enrolled shop
     * @param exploratoryGrade OPTIONAL Student's updated exploratory grade
     * @param idsOfShopChoices OPTIONAL Student's updated list of IDs of the student's shop choices
     */
    @PatchMapping(path = "/{id}")
    public void updateStudent(@PathVariable Integer id,
                              @RequestParam (required = false) String firstName,
                              @RequestParam (required = false) String lastName,
                              @RequestParam (required = false) Integer idOfEnrolledShop,
                              @RequestParam (required = false) Double exploratoryGrade,
                              @RequestParam (required = false) List<Integer> idsOfShopChoices) {
        model.updateStudentWithId(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade,
                idsOfShopChoices);
    }

    //endregion

}
