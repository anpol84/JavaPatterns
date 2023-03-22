package hello.item;

import hello.order.Order;
import hello.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;


    public void save(Item item, Long id) {
        item.setOrder(orderRepo.findById(id));
        System.out.println(item.getOrder().getOrderDate());
        itemRepo.save(item);
    }

    public List<Item> findAll(){
        return itemRepo.findAll();
    }

    public void deleteById(Long id){
        itemRepo.deleteById(id);
    }
    public Item findById(Long id){
        return itemRepo.findById(id);
    }
    public Order getOrder(Long id){
        return findById(id).getOrder();
    }
}
