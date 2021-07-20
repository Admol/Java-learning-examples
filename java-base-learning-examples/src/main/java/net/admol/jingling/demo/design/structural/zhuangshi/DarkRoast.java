package net.admol.jingling.demo.design.structural.zhuangshi;

/**
 * 烘焙咖啡
 * @author : jingling
 * @Date : 2021/7/16
 */
public class DarkRoast implements Beverage{

    /**
     * 返回基础价格
     * @return
     */
    @Override
    public double cost(){
        return 10;
    }
}
