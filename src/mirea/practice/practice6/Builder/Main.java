package mirea.practice.practice6.Builder;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass.Builder(10, 20).build();
        System.out.println(myClass);
        MyClass myClass1 = new MyClass.Builder(4, 3).d(4).f(1).build();
        System.out.println(myClass1);
    }
}
