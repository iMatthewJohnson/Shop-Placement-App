package info.oldcolony.shopplacementapp.cruds;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shops")
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer capacity;
    @ElementCollection
    private List<Long> idsOfStudentsEnrolled;

    public Shop() {
        super();
    }

    public Shop(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
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

    public List<Long> getIdsOfStudentsEnrolled() {
        return new ArrayList<>(idsOfStudentsEnrolled); // makes copy of ArrayList top avoid modification
    }

    public boolean enrollStudentWithId(Long id) {
        if (isFull()) return false;
        if (idsOfStudentsEnrolled.contains(id)) return true;
        idsOfStudentsEnrolled.add(id);
        return true;
    }

    public void unenrollStudentWithId(Long id) {
        idsOfStudentsEnrolled.remove(id);
    }

    public boolean isFull() {
        return idsOfStudentsEnrolled.size() >= capacity;
    }
}
