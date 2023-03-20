package hello;



import hello.item.Item;
import hello.item.ItemRepo;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        ItemRepo repository = context.getBean(ItemRepo.class);



       repository.save(new Item("item1", new Date(40, 2, 23), 1000));
       repository.save(new Item("item2", new Date(35, 5, 6), 2000));
       repository.save(new Item("item3", new Date(56, 6, 13), 3000));



        Iterable<Item> customers = repository.findAll();
        System.out.println("Items found with findAll():");
        System.out.println("-------------------------------");
        for (Item customer : customers) {
            System.out.println(customer);
        }
        System.out.println();



        context.close();
        SpringApplication.run(Main.class, args);


    }
}