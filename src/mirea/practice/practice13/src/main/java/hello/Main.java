package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        Student student = context.getBean(Student.class);
        System.out.println(student.getName());
        System.out.println(student.getLast_name());
        System.out.println(student.getGroup());
    }
}
