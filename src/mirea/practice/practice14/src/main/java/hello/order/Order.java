package hello.order;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "orders")
public class Order {
    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Order(){}

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", id=" + id +
                '}';
    }

    private Date orderDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
