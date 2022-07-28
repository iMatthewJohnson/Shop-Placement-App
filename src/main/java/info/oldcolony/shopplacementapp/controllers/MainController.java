package info.oldcolony.shopplacementapp.controllers;

import info.oldcolony.shopplacementapp.RepositoryElement;
import info.oldcolony.shopplacementapp.model.ShopPlacementModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO: Add class-level description in documentation
public class MainController<T extends RepositoryElement> {

    @Autowired
    ShopPlacementModel<T> model;

    //region GET requests
    /**
     * Looks up and returns an element with a given ID from the model
     * @param id id of the element that is being requested
     * @return Element of requested object
     */
    @GetMapping(path = "/{id}")
    public T getById(@PathVariable Integer id) {
        Optional<T> element = model.getElementById(id);
        return element.get();
    }

    /**
     * Looks up and returns a list of students with the given student IDs
     * @param ids Student IDs of the students being requested
     * @return List of {@code Student} objects requested. If a student ID could not be found, it will be omitted from
     * the list.
     */
    @GetMapping(produces = "application/json")
    public List<T> getByIds(@RequestParam List<Integer> ids) {
        return model.getElementsByIds(ids);
    }

    /**
     * Looks up and returns all the {@code Student} objects
     * @return List of all {@code Student} objects
     */
    @GetMapping(path = "/all", produces = "application/json")
    public List<T> getAll() {
        return model.getAll();
    }
    //endregion

    //region POST requests

    /**
     * Takes a list of {@code Student} objects and adds them all to the application
     * @param elements List of {@code Student} objects to be added
     */
    @PostMapping(consumes = "application/json")
    public void add(@RequestBody List<T> elements) {
        model.add(elements);
    }
    //endregion

    //region PATCH requests

    /**
     * Updates a list of students' information
     * @param elements List of {@code Student} objects with their IDs (required) and the fields that need to be updated.
     */
    @PatchMapping(consumes = "application/json")
    public void update(@RequestBody List<T> elements) {
        model.update(elements);
    }
    //endregion

    //region DELETE requests

    /**
     * Removes a student from the application with the provided student's ID
     * @param id The student ID of the student to be removed
     */
    @DeleteMapping(path = "/{id}")
    public T removeElementById(@PathVariable Integer id) {
        Optional<T> element = model.getElementById(id);
        if (element.isPresent()) {
            model.remove(id);
            return element.get();
        }
        return null;
    }

    /** Removes students with the provided student ids
     * @param ids A list of student IDs of students who are to be removed
     */
    @DeleteMapping
    public void removeElementsByIds(@RequestParam List<Integer> ids) {
        model.remove(ids);
    }

    /**
     * Removes all students from application
     */
    @DeleteMapping(path = "/all")
    public void removeAllElements() {
        model.removeAll();
    }
    //endregion



}