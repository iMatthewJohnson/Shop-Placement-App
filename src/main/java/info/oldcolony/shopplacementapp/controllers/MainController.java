package info.oldcolony.shopplacementapp.controllers;

import com.sun.istack.NotNull;
import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.cruds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1") // All api request paths will be relative "/api/v1"
public class MainController {
    @Autowired
    protected ShopPlacementModel shopPlacementModel;

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

}