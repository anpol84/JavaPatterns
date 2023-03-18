package hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController() {
    }

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping
    public void save(@RequestParam Order order){
        orderService.save(order);
    }
    @GetMapping
    public Iterable<Order> findAll(){
        return orderService.findAll();
    }
    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        orderService.deleteById(id);
    }
}
