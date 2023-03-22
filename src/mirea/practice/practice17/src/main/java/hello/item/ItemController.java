package hello.item;

import hello.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        itemService.deleteById(id);
    }
    @PostMapping
    public void save(@RequestBody Item item,
                     @RequestParam Long orderId){
        itemService.save(item, orderId);
    }

    @GetMapping
    public Iterable<Item> findAll(){
        return itemService.findAll();
    }
    @GetMapping("/{id}/order")
    public Order getOrder(@PathVariable("id") Long id) {
        return itemService.getOrder(id);
    }

    @GetMapping("/search")
    public List<Item> filters(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "creationDate", required = false) String date,
                              @RequestParam(value = "price", required = false) Double price){
        return itemService.filter(name, date, price);
    }

}
