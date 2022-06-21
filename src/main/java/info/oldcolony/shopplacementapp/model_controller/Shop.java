package info.oldcolony.shopplacementapp.model_controller;

import java.util.ArrayList;
import java.util.Objects;

public class Shop {

    private final String name;
    private final int capacity;
    private final ArrayList<Student> studentsEnrolled;

    /**
     * Create a new instance {@code Shop} with a name and maximum capacity
     * @param shopName Name of the shop
     * @param shopCapacity Maximum number of students that can be enrolled
     */
    public Shop(String shopName, int shopCapacity) {
        this.name = shopName;
        this.capacity = shopCapacity;
        this.studentsEnrolled = new ArrayList<>();
    }

 /**
     * Add a new student to the shop. If the student is already enrolled or the number of students meets or exceeds
     * the shop's capacity, then the student will not be added.
     * @param student The {@code Student} to be enrolled into the shop
     * @return {@code true} if the student is successfully enrolled, {@code false} if the student is not enrolled.
     */
    public boolean addStudent(Student student) {
        if (isFull() || studentsEnrolled.contains(student)) return false;
        studentsEnrolled.add(student);
        student.setEnrolledShop(this);
        return true;
    }

    /**
     * Removes the student that is passed in as an argument from the shop's list of enrolled students.
     * @param student The {@code Student} to be removed from the shop's list of enrolled students.
     */
    public void removeStudent(Student student) {
        studentsEnrolled.remove(student);
    }

    /**
     * Removes the student with a specified {@code id} from the shop's list of enrolled students.
     * @param studentId The {@code id} number of the {@code Student} to be removed from the shop's list of enrolled students.
     */
    public void removeStudent(Integer studentId) {
        studentsEnrolled.removeIf(student -> student.getStudentId().equals(studentId));
    }

    /**
     * Checks if the shop is "full." If the number of enrolled students in the shop equals the number of
     * students currently enrolled, then the shop is considered "full."
     * @return {@code true} if the shop is currently full. {@code false} if the shop is not full.
     */
    public boolean isFull() {
        return studentsEnrolled.size() >= capacity;
    }

    /**
     * @return The name of the shop as a {@code String}
     */
    public String getName() {
        return name;
    }


    /**
      * @return The maximum number of students that can be enrolled in the shop.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return A {@code Student} array of all {@code Student}s currently enrolled in the shop
     */
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
        return name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
