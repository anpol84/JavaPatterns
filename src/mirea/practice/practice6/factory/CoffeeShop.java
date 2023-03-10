package mirea.practice.practice6.factory;

public class CoffeeShop {
    private final SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
    public Coffee OrderCoffee(CoffeeType type){
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
        return coffee;
    }
}
