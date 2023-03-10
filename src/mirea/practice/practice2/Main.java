package mirea.practice.practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human(20, "Alexey", "Petrov", LocalDate.of(2003, 1, 28),
                59));
        list.add(new Human(25, "Nikita", "Sidorov", LocalDate.of(1998, 9, 15),
                85));
        list.add(new Human(10, "Oleg", "Potapov", LocalDate.of(2013, 5, 22),
                40));
        list.add(new Human(43, "Andrey", "Petrenko", LocalDate.of(1980, 3, 5),
                65));
        list.add(new Human(15, "Kirill", "Dubov", LocalDate.of(2008, 5, 19),
                56));
        list.add(new Human(5, "Alexey", "Gubanov", LocalDate.of(2018, 6, 29),
                25));
        list.add(new Human(24, "Alina", "Petrova", LocalDate.of(1990, 1, 1),
                55));
        list.add(new Human(13, "Maria", "Sidorova", LocalDate.of(2010, 10, 11),
                45));
        list.add(new Human(66, "Nikolay", "Borisov", LocalDate.of(1957, 2, 20),
                58));
        list.add(new Human(14, "Angelina", "Klimenko", LocalDate.of(2009, 4, 25),
                52));
        list.stream().limit(5).sorted((a, b) -> a.getBirthDate().compareTo(b.getBirthDate())).
                filter(x -> x.getWeight()<60).forEach(System.out::println);
    }
}
