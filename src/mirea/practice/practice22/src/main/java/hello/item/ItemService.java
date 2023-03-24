package hello.item;

import hello.EmailService;
import hello.order.MyOrderRepo;
import hello.order.Order;
import hello.order.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.mail.MessagingException;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ItemService {

    private ItemRepo itemRepo;


    private OrderRepo orderRepo;
    private MyOrderRepo myOrderRepo;
    private final EmailService emailService;


    private MyItemRepo myItemRepo;
    @Autowired
    public ItemService(ItemRepo itemRepo, OrderRepo orderRepo, MyItemRepo myItemRepo, MyOrderRepo myOrderRepo,
                       EmailService emailService) {
        this.itemRepo = itemRepo;
        this.orderRepo = orderRepo;
        this.myItemRepo = myItemRepo;
        this.myOrderRepo = myOrderRepo;
        this.emailService = emailService;
    }

    public void save(Item item, Long id) {
        log.info("saving item {}", item);
        item.setOrder(myOrderRepo.findById(id));

        itemRepo.save(item);
        try {
            emailService.sendEmail( "Item saved", "Object: " + item);
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }

    public List<Item> findAll(){
        log.info("finding all items");
        return itemRepo.findAll();
    }

    public void deleteById(Long id){
        log.info("deleting item with id {}", id);
        itemRepo.deleteById(id);
    }
    public Item findById(Long id){
        log.info("finding item by id {}", id);
        return myItemRepo.findById(id);
    }
    public Order getOrder(Long id){
        log.info("getting order by id {}", id);
        return findById(id).getOrder();
    }
    public List<Item> filter(String name, String date, Double price){
        log.info("filtering item");
        return myItemRepo.filter(name, date, price);
    }

}
