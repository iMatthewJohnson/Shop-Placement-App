package info.oldcolony.shopplacementapp.controllers;

import com.sun.istack.NotNull;
import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1") // All api request paths will be relative "/api/v1"
public class MainController {
    @Autowired
    protected ShopPlacementModel shopPlacementModel;

    /**
     * Post request that adds new user {@code firstName} and {@code lastName} to Student Repository database and model.
     * @param firstName first name of student to be added
     * @param lastName last name of student to be added
     * @return response body that indicates that new user was saved successfully.
     */
    @PostMapping(path="/users/students/add")
    public @ResponseBody String addNewStudent(@RequestParam @NotNull Integer id,
                                              @RequestParam @NonNull String firstName,
                                            @RequestBody @NonNull String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Student student = new Student(id, firstName, lastName);
        shopPlacementModel.add(student);
        return "";
    }

    /**
     *
     */
//    @PutMapping(path="/users/students/all/place_students")
//    public void placeStudentsIntoShops() {
//        shopPlacementModel.placeStudentsInShops();
//        HashMap<Integer, Student> modelsStudents = shopPlacementModel.getAllStudents();
//        for(Integer studentId : modelsStudents.keySet()) {
//            Student student = modelsStudents.get(studentId);
//            if (student.getEnrolledShop() != null) {
//                StudentEntity se = studentRepository.findById(studentId).get();
//                se.setIdOfEnrolledShop(student.getEnrolledShop().getName());
//                studentRepository.save(se);
//            }
//        }
//    }


    @GetMapping(path="/users/students/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return shopPlacementModel.getAllStudents();
    }

}