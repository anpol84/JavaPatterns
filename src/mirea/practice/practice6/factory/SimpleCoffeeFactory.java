package mirea.practice.practice6.factory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(CoffeeType type){
        Coffee coffee = null;
        switch (type){
            case ESPRESSO -> coffee = new Espresso();
            case AMERICANO -> coffee = new Americano();
            case CAFFE_LATTE -> coffee = new CaffeLatte();
            case CAPPUCCINO -> coffee = new Cappuccino();
        }
        return coffee;
    }
}
