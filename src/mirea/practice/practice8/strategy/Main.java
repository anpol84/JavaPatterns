package mirea.practice.practice8.strategy;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();

        Activity activity = new Sleeping();

        developer.setActivity(activity);
        developer.toDo();

        developer.setActivity(new Training());
        developer.toDo();

        developer.setActivity(new Coding());
        developer.toDo();

        developer.setActivity(new Reading());
        developer.toDo();
    }
}
