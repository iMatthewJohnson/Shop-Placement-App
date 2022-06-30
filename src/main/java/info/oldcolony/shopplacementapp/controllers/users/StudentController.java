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

    /**
     * Looks up and returns a list of students with the given student IDs
     * @param ids Student IDs of the students being requested
     * @return List of {@code Student} objects requested. If a student ID could not be found, it will be omitted from
     * the list.
     */
    @GetMapping(produces = "application/json")
    public List<Student> getStudentsByIds(@RequestParam (value="ids") List<Integer> ids) {
        return model.getElementsByIds(ids);
    }

    /**
     * Looks up and returns all the {@code Student} objects
     * @return List of all {@code Student} objects
     */
    @GetMapping(path = "/all", produces = "application/json")
    public List<Student> getAllStudents() {
        return model.getAll();
    }
    //endregion

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
    public void addStudent(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "idOfEnrolledShop", required = false) Integer idOfEnrolledShop,
                           @RequestParam(value = "exploratoryGrade", required = false) Double exploratoryGrade,
                           @RequestParam(value = "idOfShopChoices", required = false) List<Integer> idsOfShopChoices) {
        Student newStudent = new Student(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade, idsOfShopChoices);
        model.add(newStudent);
    }

    /**
     * Takes a list of {@code Student} objects and adds them all to the application
     * @param students List of {@code Student} objects to be added
     */
    @PostMapping(consumes = "application/json")
    public void addStudents(@RequestBody List<Student> students) {
        model.add(students);
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
                              @RequestParam (value = "firstName", required = false) String firstName,
                              @RequestParam (value = "lastName", required = false) String lastName,
                              @RequestParam (value = "idOfEnrolledShop", required = false) Integer idOfEnrolledShop,
                              @RequestParam (value = "exploratoryGrade", required = false) Double exploratoryGrade,
                              @RequestParam (value = "idsOfShopChoices", required = false) List<Integer> idsOfShopChoices) {
        model.updateStudentWithId(id, firstName, lastName, idOfEnrolledShop, exploratoryGrade,
                idsOfShopChoices);
    }

    /**
     * Updates a list of students' information
     * @param students List of {@code Student} objects with their IDs (required) and the fields that need to be updated.
     */
    @PatchMapping(consumes = "application/json")
    public void updateStudents(@RequestBody List<Student> students) {
        model.updateStudents(students);
    }
    //endregion

    //region DELETE requests

    /**
     * Removes a student from the application with the provided student's ID
     * @param id The student ID of the student to be removed
     */
    @DeleteMapping(path = "/{id}")
    public void removeStudentById(@PathVariable Integer id) {
        model.remove(id);
    }

    /** Removes students with the provided student ids
     * @param ids A list of student IDs of students who are to be removed
     */
    @DeleteMapping
    public void removeStudentsByIds(@RequestParam List<Integer> ids) {
        model.remove(ids);
    }

    /**
     * Removes all students from application
     */
    @DeleteMapping(path = "/all")
    public void removeAllStudents() {
        model.removeAll();
    }
    //endregion
}
