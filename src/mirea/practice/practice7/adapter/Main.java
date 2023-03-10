package mirea.practice.practice7.adapter;

public class Main {
    public static void main(String[] args) {
        Database database = new DatabaseAdapter();
        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
