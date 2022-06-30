package info.oldcolony.shopplacementapp.controllers;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class MainController<T> {

    @Autowired
    ShopPlacementModel<T> model;

    //region GET requests
    /**
     * Looks up and returns a {@code Student} object with a given student ID
     * @param id Student ID of the student that is being requested
     * @return {@code Student} object of student requested
     */
    @GetMapping(path = "/{id}")
    public T getById(@PathVariable Integer id) {
        Optional<T> element = model.getElementById(id);
        return element.get();
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

}