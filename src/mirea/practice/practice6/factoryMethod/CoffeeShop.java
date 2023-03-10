package mirea.practice.practice6.factoryMethod;



public abstract class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type){
        Coffee coffee = createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
        System.out.println(coffee);
        return coffee;
    }
    public abstract Coffee createCoffee(CoffeeType type);

}
