package entities;
import javax.persistence.*;


@Entity
@Table(name = "roles")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
public class Role extends BaseEntity {
    private String name;

    @Column(name = "name" , nullable = false )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
