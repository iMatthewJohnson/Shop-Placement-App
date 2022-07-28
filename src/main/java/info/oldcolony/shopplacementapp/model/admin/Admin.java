package info.oldcolony.shopplacementapp.model.admin;

import info.oldcolony.shopplacementapp.RepositoryElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends RepositoryElement {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    public Admin() {
        super();
    }

    public Admin(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
