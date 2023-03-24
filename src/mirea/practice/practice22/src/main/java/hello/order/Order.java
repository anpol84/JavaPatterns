package hello.order;

import hello.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Override
    public String toString() {
        return "Order{" +
                "orderDate='" + orderDate + '\'' +
                ", items=" + items +
                ", id=" + id +
                '}';
    }

    @Column(name="order_date")
    private String orderDate;

    public Order(String orderDate) {
        this.orderDate = orderDate;
    }
    public Order(){}
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
