package hello.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    private OrderRepo orderRepo;
    private MyOrderRepo myOrderRepo;

    public OrderService() {
    }
    @Autowired
    public OrderService(OrderRepo orderRepo, MyOrderRepo myOrderRepo){
        this.orderRepo = orderRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public void save(Order order){
        log.info("saving order {}", order);
        orderRepo.save(order);
    }

    public List<Order> findAll(){
        log.info("finding all orders");
        return orderRepo.findAll();
    }

    public void deleteById(Long id){
        log.info("deleting order by id {}", id);
        orderRepo.deleteById(id);
    }
    public Order findById(Long id) {
        log.info("finding order by id {}", id);
        return myOrderRepo.findById(id);
    }
    public List<Order> filter(String date){
        log.info("filtering order");
        return myOrderRepo.filter(date);
    }
}
