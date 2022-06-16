package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ShopPlacementModel {

    private HashMap<Integer, Student> students;


    /**
     * Creates a new (@code ShopPlacementModel} with no students added.
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
     * 
     */
    public Student[] placeStudents() {
        Student[] studentList = sortStudentsByGrade();
        for (Student student : studentList) {
            student.setEnrolledShop(null);
            int i = 0;
            Shop highestChoice = student.getShopChoiceAtIndex(i);
            while(!highestChoice.addStudent(student) && i < 5) {
                highestChoice = student.getShopChoiceAtIndex(++i);
            }
        }
        return studentList;
    }

    private Student[] sortStudentsByGrade() {
        ArrayList<Student> rankedStudentList = new ArrayList<>(students.values()); // ArrayList of all Student objects
        Collections.sort(rankedStudentList);
        Student[] rankedStudentArray = new Student[rankedStudentList.size()];
        rankedStudentList.toArray(rankedStudentArray);
        return (rankedStudentArray);
    }

    public HashMap<Integer, Student> getStudents() {
        return new HashMap<>(students);
    }
}
