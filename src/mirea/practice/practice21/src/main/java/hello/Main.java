package hello;

import hello.item.Item;
import hello.item.ItemRepo;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class Main {
    public static void main(String[] args) {


        SpringApplication.run(Main.class, args);

    }
}