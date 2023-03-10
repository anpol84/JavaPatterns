package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class Main {
    public static void main(String[] args) {
        //args = new String[]{"Trump"};
        //args = new String[]{"Biden"};
        args = new String[]{"Merkel"};
        if (args.length == 0){
            System.out.println("No data");
            return;
        }
        Politician politician = null;
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        switch (args[0]){
            case "Trump":
                politician = context.getBean(Trump.class);
                break;
            case "Biden":
                politician = context.getBean(Biden.class);
                break;
            case "Merkel":
                politician = context.getBean(Merkel.class);
                break;
            default:
                System.out.println("No such class");
                return;
        }
        politician.doPolitic();
    }
}