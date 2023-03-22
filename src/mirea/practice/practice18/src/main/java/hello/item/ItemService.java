package hello.item;

import hello.order.MyOrderRepo;
import hello.order.Order;
import hello.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepo itemRepo;


    private OrderRepo orderRepo;
    private MyOrderRepo myOrderRepo;

    private MyItemRepo myItemRepo;
    @Autowired
    public ItemService(ItemRepo itemRepo, OrderRepo orderRepo, MyItemRepo myItemRepo, MyOrderRepo myOrderRepo) {
        this.itemRepo = itemRepo;
        this.orderRepo = orderRepo;
        this.myItemRepo = myItemRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public void save(Item item, Long id) {
        item.setOrder(myOrderRepo.findById(id));

        itemRepo.save(item);
    }

    public List<Item> findAll(){
        return itemRepo.findAll();
    }

    public void deleteById(Long id){
        itemRepo.deleteById(id);
    }
    public Item findById(Long id){
        return myItemRepo.findById(id);
    }
    public Order getOrder(Long id){
        return findById(id).getOrder();
    }
    public List<Item> filter(String name, String date, Double price){
        return myItemRepo.filter(name, date, price);
    }
}
