package hello.item;

import hello.order.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private String creationDate;

    private OrderDTO order;

    public static ItemDTO withoutOrder(Item item) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setCreationDate(item.getCreationDate());


        return itemDTO;
    }

    public static ItemDTO withOrder(Item item) {
        ItemDTO itemDTO = withoutOrder(item);


        itemDTO.setOrder(OrderDTO.withoutItem(item.getOrder()));



        return itemDTO;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", order=" + order +
                '}';
    }
}
