package hello.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        itemService.deleteById(id);
    }
    @PostMapping
    public Item save(@RequestBody Item item){
        return itemService.save(item);
    }

    @GetMapping
    public Iterable<Item> findAll(){
        return itemService.findAll();
    }
}
