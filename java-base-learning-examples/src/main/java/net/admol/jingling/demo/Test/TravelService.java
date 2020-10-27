package net.admol.jingling.demo.Test;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
public interface TravelService{
    /**
     * 旅行
     * @return
     */
    String travel();

    /**
     * 方式
     * @return
     */
    TravelEnum getType();
}
