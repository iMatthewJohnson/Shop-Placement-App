package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Shop {

    private final String name;
    private final int capacity;
    private ArrayList<Student> studentsEnrolled;

    public Shop(String shopName, int shopCapacity) {
        this.name = shopName;
        this.capacity = shopCapacity;
        this.studentsEnrolled = new ArrayList<>();
    }

    public void addStudent(Student student) throws DuplicateEntryException {
     if (studentsEnrolled.contains(student)) {
         throw new DuplicateEntryException("Student already enrolled in shop");
     } else {
         studentsEnrolled.add(student);
         student.setEnrolledShop(this);
     }
    }

    public void removeStudent(Student student) {
        studentsEnrolled.remove(student);
    }

    public void removeStudent(String studentId) {
        studentsEnrolled.removeIf(student -> student.getStudentId().equals(studentId));
    }

    public boolean isFull() {
        return studentsEnrolled.size() >= capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Student[] getStudentsEnrolled() {
        return (Student[]) studentsEnrolled.toArray().clone();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return name == shop.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
