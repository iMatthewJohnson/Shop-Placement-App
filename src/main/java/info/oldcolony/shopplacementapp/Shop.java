package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
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

    public boolean addStudent(Student student) {
        if (isFull() || studentsEnrolled.contains(student)) return false;
        studentsEnrolled.add(student);
        student.setEnrolledShop(this);
        return true;
    }

    public void removeStudent(Student student) {
        studentsEnrolled.remove(student);
    }

    public void removeStudent(Integer studentId) {
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
        Student[] studentsEnrolledArray = new Student[studentsEnrolled.size()];
        studentsEnrolled.toArray(studentsEnrolledArray);
        return studentsEnrolledArray;
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
