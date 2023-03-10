package mirea.practice.practice6.factoryMethod;


public class ItalianCoffeeShop extends CoffeeShop {
    @Override
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;
        switch (type){
            case ESPRESSO -> coffee = new ItalianStyleEspresso();
            case AMERICANO -> coffee = new ItalianStyleAmericano();
            case CAFFE_LATTE -> coffee = new ItalianStyleCaffeLatte();
            case CAPPUCCINO -> coffee = new ItalianStyleCappuccino();
        }
        return coffee;
    }
}
