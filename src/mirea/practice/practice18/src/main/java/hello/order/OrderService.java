package hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        orderRepo.save(order);
    }

    public List<Order> findAll(){
        return orderRepo.findAll();
    }

    public void deleteById(Long id){
        orderRepo.deleteById(id);
    }
    public Order findById(Long id) {
        return myOrderRepo.findById(id);
    }
    public List<Order> filter(String date){
        return myOrderRepo.filter(date);
    }
}
