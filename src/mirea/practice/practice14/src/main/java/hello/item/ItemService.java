package hello.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }
    public Item save(Item item){
        return itemRepo.save(item);
    }

    public Iterable<Item> findAll(){
        return itemRepo.findAll();
    }

    public void deleteById(Long id){
        itemRepo.deleteById(id);
    }
}
