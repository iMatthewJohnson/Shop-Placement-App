package info.oldcolony.shopplacementapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Shop {
    
    public static final HashMap<String, Integer> SHOPS_AND_CAPACITY = createShopAndCapacityMap();

    private final String name;
    private final int capacity;
    private ArrayList<Student> studentsEnrolled;

    public Shop(String shopName, int shopCapacity) {
        this.name = shopName;
        this.capacity = shopCapacity;
        this.studentsEnrolled = new ArrayList<>();
    }

    public Shop(String shopName) {
        this (shopName, SHOPS_AND_CAPACITY.get(shopName));
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

    private static HashMap<String, Integer> createShopAndCapacityMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Automotive", 12);
        map.put("Electronics", 8);
        map.put("Computer Science", 8);
        return map;
    }
}
