package info.oldcolony.shopplacementapp.model.student;

import info.oldcolony.shopplacementapp.RepositoryElement;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO: Add documentation
@Entity
@Table(name="students")
public class Student extends RepositoryElement {
    @Id
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer idOfEnrolledShop = null;
    private Double exploratoryGrade = null;
    @ElementCollection
    private List<Integer> idsOfShopChoices = null;

    public Student() {
        super();
    }

    public Student(@NonNull Integer studentId,
                   @NonNull String firstName,
                   @NonNull String lastName,
                   @Nullable Integer idOfEnrolledShop,
                   @Nullable Double exploratoryGrade,
                   @Nullable List<Integer> idsOfShopChoices) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idOfEnrolledShop = idOfEnrolledShop;
        this.exploratoryGrade = exploratoryGrade;
        this.idsOfShopChoices = idsOfShopChoices;
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

    public Double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(Double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public List<Integer> getIdsOfShopChoices() {
        return new ArrayList<>(this.idsOfShopChoices);
    }

    public void setIdsOfShopChoices(List<Integer> idsOfShopChoices) {
        if (idsOfShopChoices == null) idsOfShopChoices = new ArrayList<>();
        this.idsOfShopChoices = idsOfShopChoices;
    }

    public void setIdOfShopChoiceAtIndex(int index, Integer idOfShopChoice) {
        if (idsOfShopChoices == null) idsOfShopChoices = new ArrayList<>();
        if (index == idsOfShopChoices.size()) idsOfShopChoices.add(index, idOfShopChoice);
        // if the size of the list of idsOfShopChoices is less than or equal to the index, then fill in the elements
        // in between the last element and the element being added, with null
        if (index > idsOfShopChoices.size()) {
            for (int i = idsOfShopChoices.size(); i <= index; i++) {
                idsOfShopChoices.add(i, null);
            }
        }
        idsOfShopChoices.set(index, idOfShopChoice);
    }

    public Integer getIdOfShopChoiceAtIndex(int index) {
        return idsOfShopChoices.get(index);
    }


    @Override
    public String toString() {
        String theString =
                "{\"studentId\":" + studentId + "," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"idOfEnrolledShop\":" + idOfEnrolledShop + "," +
                "\"exploratoryGrade\":" + exploratoryGrade + "," +
                "\"idsOfShopChoices\":" + "[" + idsOfShopChoices + "]}";
        return theString.replaceAll("\\s+",""); // Strip all whitespace
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!studentId.equals(student.studentId)) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!Objects.equals(idOfEnrolledShop, student.idOfEnrolledShop))
            return false;
        if (!Objects.equals(exploratoryGrade, student.exploratoryGrade))
            return false;
        return Objects.equals(idsOfShopChoices, student.idsOfShopChoices);
    }

    @Override
    public int hashCode() {
        int result = studentId.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
