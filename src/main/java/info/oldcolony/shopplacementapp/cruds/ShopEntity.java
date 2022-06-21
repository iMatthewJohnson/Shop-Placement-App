package info.oldcolony.shopplacementapp.cruds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer capacity;

    public ShopEntity(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public void setId(Integer id) {
        this.id = id;
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
}
