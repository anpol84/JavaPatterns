package hello.order;

import hello.item.Item;
import hello.item.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String orderDate;
    private List<ItemDTO> items;

    public static OrderDTO withoutItem(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());


        return orderDTO;
    }

    public static OrderDTO withItem(Order order) {
        OrderDTO orderDTO = withoutItem(order);


        orderDTO.setItems(order.getItems().stream().map(ItemDTO::withoutOrder).toList());


        return orderDTO;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", items=" + items +
                '}';
    }
}
