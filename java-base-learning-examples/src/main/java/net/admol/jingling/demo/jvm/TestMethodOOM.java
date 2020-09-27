package net.admol.jingling.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区溢出测试
 * 需要在jdk1.7之前才会出现异常结果
 * jvm args: -XX:PermSize=5M -XX:MaxPermSize=5M
 * @author : admol
 * @Date : 2020/9/24
 */
public class TestMethodOOM{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int i = 1000000;
        while(true){
            list.add((String.valueOf(i++).intern()));
        }
    }
}
