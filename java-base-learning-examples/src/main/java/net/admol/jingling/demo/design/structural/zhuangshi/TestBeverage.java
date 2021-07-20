package net.admol.jingling.demo.design.structural.zhuangshi;

/**
 * @author : jingling
 * @Date : 2021/7/16
 */
public class TestBeverage{

    public static void main(String[] args){
        // 首选咖啡
        Beverage beverage = new HouseBlend();
        // 加牛奶5元
        beverage = new Milk(beverage);
        // 加奶茶5元
        beverage = new Mocha(beverage);
        // 输出价格
        System.out.println(beverage.cost());
    }
}
