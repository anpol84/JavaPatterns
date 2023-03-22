package hello.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.order.Order;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {

    private String name;
    private String creationDate;
    private double price;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;


    public Item(String name, String creationDate, double price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    public Item() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
