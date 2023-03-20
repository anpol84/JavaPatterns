package hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepo orderRepo;


    @Autowired
    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public Order save(Order order){
        return orderRepo.save(order);
    }

    public Iterable<Order> findAll(){
        return orderRepo.findAll();
    }

    public void deleteById(Long id){
        orderRepo.deleteById(id);
    }
}
