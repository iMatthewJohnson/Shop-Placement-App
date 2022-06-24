package info.oldcolony.shopplacementapp.model.cruds;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="students")
public class Student {
    @Id
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer idOfEnrolledShop = null;
    private Double exploratoryGrade = 0.0;
    @ElementCollection
    private List<Integer> idsOfShopChoices = null;

    public Student() {
        super();
    }

    public Student(Integer studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getIdOfEnrolledShop() {
        return idOfEnrolledShop;
    }

    public void setIdOfEnrolledShop(Integer enrolledShopId) {
        this.idOfEnrolledShop = enrolledShopId;
    }

    public double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public List<Integer> getIdsOfShopChoices() {
        return new ArrayList<Integer>(this.idsOfShopChoices);
    }

    public void setIdsOfShopChoices(List<Integer> idsOfShopChoices) {
        this.idsOfShopChoices = idsOfShopChoices;
    }

    public void setIdOfShopChoiceAtIndex(int index, Integer idOfShopChoice) {
        idsOfShopChoices.set(index, idOfShopChoice);
    }

    public Integer getIdOfShopChoiceAtIndex(int index) {
        return idsOfShopChoices.get(index);
    }
}
