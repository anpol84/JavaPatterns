package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.item.Item;
import hello.item.ItemDTO;
import hello.item.ItemService;
import hello.order.Order;
import hello.order.OrderDTO;
import hello.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@ManagedResource(objectName = "practice22:name=SchedulerService")
public class SchedulerService {
    private final OrderService orderService;
    private final ItemService itemService;
    private final String path = "C:\\Users\\User\\IdeaProjects\\JavaPattrens\\src\\mirea\\practice\\practice22\\info";
    @Autowired
    public SchedulerService(OrderService orderService, ItemService itemService) {
        this.orderService = orderService;
        this.itemService = itemService;
    }

    @ManagedOperation(description = "Creates DB files")
    @Scheduled(fixedDelay = 1800000)
    public void updateDirectory() throws IOException {
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        File file = new File(path+"\\Item.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        List<ItemDTO> items = itemService.findAll().stream().map(ItemDTO::withoutOrder).toList();
        for (ItemDTO item : items){
            fileWriter.write(item.toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
        File file1 = new File(path+"\\Order.txt");
        file1.createNewFile();
        FileWriter fileWriter1 = new FileWriter(file1);
        List<OrderDTO> orders = orderService.findAll().stream().map(OrderDTO::withoutItem).toList();
        for (OrderDTO order : orders){
            fileWriter1.write(order.toString());
            fileWriter1.write("\n");
        }
        fileWriter1.close();
    }
}
