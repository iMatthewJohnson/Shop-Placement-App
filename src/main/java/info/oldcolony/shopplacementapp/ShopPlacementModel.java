package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ShopPlacementModel {

    private HashMap<Integer, Student> students = new HashMap<>();
    private ArrayList<Student> rankedStudentList;


    public ShopPlacementModel(Student[] students) {

        for (Student student : students) {
            this.students.put(student.getStudentId(), student);
        }
    }

    public void placeStudents() {
        //TODO: Main method where all students are sorted into their shop
        Student[] rankedStudentList = sortStudentsByGrade();
        for (Student student : rankedStudentList) {
            int i = 0;
            Shop highestChoice = student.getShopChoiceAtIndex(i);
            while (highestChoice.isFull() && i < 5) {
                highestChoice = student.getShopChoiceAtIndex(i++);
            }
            try {
                if (i < 5) highestChoice.addStudent(student);
            } catch (DuplicateEntryException e) {
                e.printStackTrace();
            }
        }
    }


    private Student[] sortStudentsByGrade() {
        rankedStudentList = new ArrayList<>(students.values());
        Collections.sort(rankedStudentList);
        Student[] rankedStudentArray = new Student[rankedStudentList.size()];
        rankedStudentList.toArray(rankedStudentArray);
        return (rankedStudentArray);
    }

    public HashMap<Integer, Student> getStudents() {
        return new HashMap<>(students);
    }
}
