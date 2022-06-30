package info.oldcolony.shopplacementapp.model.shop;

import info.oldcolony.shopplacementapp.RepositoryElement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shops")
public class Shop implements RepositoryElement {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer capacity;
    @ElementCollection
    private List<Integer> idsOfStudentsEnrolled;

    public Shop() {
        super();
    }

    public Shop(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Integer> getIdsOfStudentsEnrolled() {
        return new ArrayList<>(idsOfStudentsEnrolled); // makes copy of ArrayList top avoid modification
    }

    public boolean enrollStudentWithId(Integer id) {
        if (isFull()) return false;
        if (idsOfStudentsEnrolled.contains(id)) return true;
        idsOfStudentsEnrolled.add(id);
        return true;
    }

    public void unenrollStudentWithId(Integer id) {
        idsOfStudentsEnrolled.remove(id);
    }

    public boolean isFull() {
        return idsOfStudentsEnrolled.size() >= capacity;
    }
}
