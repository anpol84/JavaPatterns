package hello.item;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {
    private String name;
    private Date creationDate;
    private double price;

    public Item() {
    }

    public Item(String name, Date creationDate, double price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", id=" + id +
                '}';
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
