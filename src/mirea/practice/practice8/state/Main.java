package mirea.practice.practice8.state;

public class Main {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();
        developer.setActivity(activity);

        for (int i = 0; i < 15; i++){
            developer.toDo();
            developer.changeActivity();
        }
    }
}
