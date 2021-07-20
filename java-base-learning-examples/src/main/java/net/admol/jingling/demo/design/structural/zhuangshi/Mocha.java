package net.admol.jingling.demo.design.structural.zhuangshi;

/**
 * @author : jingling
 * @Date : 2021/7/16
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    /**
     * 抹茶也要加5元
     * @return
     */
    @Override
    public double cost(){
        return 5 + beverage.cost();
    }
}
