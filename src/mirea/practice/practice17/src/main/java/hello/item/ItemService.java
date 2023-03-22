package hello.item;

import hello.order.Order;
import hello.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    private ItemRepo itemRepo;


    private OrderRepo orderRepo;
    @Autowired
    public ItemService(ItemRepo itemRepo, OrderRepo orderRepo) {
        this.itemRepo = itemRepo;
        this.orderRepo = orderRepo;
    }

    public void save(Item item, Long id) {
        item.setOrder(orderRepo.findById(id));

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

    public List<Item> filter(String name, String date, Double price){
        return itemRepo.filter(name, date, price);
    }
}
