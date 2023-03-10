package mirea.practice.practice6.factory;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        Coffee coffee1 = coffeeShop.OrderCoffee(CoffeeType.AMERICANO);
        System.out.println(coffee1);
        Coffee coffee2 = coffeeShop.OrderCoffee(CoffeeType.ESPRESSO);
        System.out.println(coffee2);
        Coffee coffee3 = coffeeShop.OrderCoffee(CoffeeType.CAPPUCCINO);
        System.out.println(coffee3);
        Coffee coffee4 = coffeeShop.OrderCoffee(CoffeeType.CAFFE_LATTE);
        System.out.println(coffee4);

    }
}
