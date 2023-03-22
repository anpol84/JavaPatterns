package hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController() {
    }
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping
    public void save(@RequestBody Order order){
        orderService.save(order);
    }
    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }
    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        orderService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }
    @GetMapping("/search")
    public List<Order> filter(@RequestParam(value = "orderDate", required = false) String date){
        return orderService.filter(date);
    }

}
