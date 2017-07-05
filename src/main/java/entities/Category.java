package entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@AttributeOverride(name = "id", column = @Column(name = "category_id"))
public class Category extends BaseEntity{

    private String name;

    @Column(name = "name" , nullable = false )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
