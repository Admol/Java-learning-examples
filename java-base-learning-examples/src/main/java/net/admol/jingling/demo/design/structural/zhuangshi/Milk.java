package net.admol.jingling.demo.design.structural.zhuangshi;

/**
 * 饮料加牛奶
 * @author : jingling
 * @Date : 2021/7/16
 */
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * +5元
     * @return
     */
    @Override
    public double cost(){
        return 5 + beverage.cost();
    }
}
