package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ShopPlacementModel {

    private HashMap<Integer, Student> students;


    /**
     * Creates a new {@code ShopPlacementModel} with no initial students added.
     */
    public ShopPlacementModel() {
        this(null);
    }
    
    /**
     * Creates a new {@code ShopPlaceMentModel} with a list of {@code Student} objects.
     * @param students The list of students to be added to the model
     */
    public ShopPlacementModel(Student[] students) {
        if (students == null) this.students = new HashMap<>();
        for (Student student : students) {
            this.students.put(student.getStudentId(), student);
        }
    }

    /**
     * Adds a new student to the model
     * @param student The student to be added to the model
     */
    public void add(Student student) {
        // Check if student Id already exists in the model, and only add if it doesn't exist
        if (!students.containsKey(student.getStudentId()))
            this.students.put(student.getStudentId(), student);
    }

    /**
     * Enroll students into their shops and returns an array of all the {@code Student} objects. All students must
     * have an exploratory grade in order to run this method
     *
     */
    public Student[] placeStudentsInShops() {
        if (!allStudentsHaveExploratoryGrade()) throw new IllegalStateException("Not all students have exploratory " +
                "grades. All students must have an exploratory grade in order to run method");
        Student[] studentList = sortStudentsByGrade();
        for (Student student : studentList) {
            student.setEnrolledShop(null);
            int choice = 0;
            Shop highestChoice = student.getShopChoiceAtIndex(choice);
            while(!highestChoice.addStudent(student) && choice < 5) {
                highestChoice = student.getShopChoiceAtIndex(++choice);
            }
        }
        return studentList;
    }

    /**
     * @return HasMap of all students, where the students' student ids are the keys.
     */
    public HashMap<Integer, Student> getStudents() {
        return new HashMap<>(students);
    }

    private boolean allStudentsHaveExploratoryGrade() {
        for (Student student : students.values()) {
            if (student.getExploratoryGrade() <= 0) return false;
        }
        return true;
    }

    private Student[] sortStudentsByGrade() {
        ArrayList<Student> rankedStudentList = new ArrayList<>(students.values()); // ArrayList of all Student objects
        Collections.sort(rankedStudentList);
        Student[] rankedStudentArray = new Student[rankedStudentList.size()];
        rankedStudentList.toArray(rankedStudentArray);
        return (rankedStudentArray);
    }
}
