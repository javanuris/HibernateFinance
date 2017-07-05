package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@AttributeOverride(name = "id", column = @Column(name = "transaction_id"))
public class Transaction extends BaseEntity {
    private Date start;
    private Date end;
    private Integer status;
    private User user;
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Date getStart() {
        return start;
    }


    public void setStart(Date start) {
        this.start = start;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end")
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Column(name = "status" , nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_transaction"),nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product"),nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
