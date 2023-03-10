package mirea.practice.practice6.factoryMethod;

public class AmericanCoffeeShop extends CoffeeShop{
    @Override
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;
        switch (type){
            case ESPRESSO -> coffee = new AmericanStyleEspresso();
            case AMERICANO -> coffee = new AmericanStyleAmericano();
            case CAFFE_LATTE -> coffee = new AmericanStyleCaffeLatte();
            case CAPPUCCINO -> coffee = new AmericanStyleCappuccino();
        }
        return coffee;
    }
}
