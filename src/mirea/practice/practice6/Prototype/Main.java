package mirea.practice.practice6.Prototype;

public class Main {
    public static void main(String[] args) {
        ComplicatedObject object1 = new ComplicatedObject(1, "first object");
        System.out.println(object1);
        ComplicatedObject object2 = object1.clone();
        System.out.println(object2);
    }
}
