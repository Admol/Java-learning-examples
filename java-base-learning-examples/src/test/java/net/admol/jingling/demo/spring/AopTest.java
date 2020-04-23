package net.admol.jingling.demo.spring;

import net.admol.jingling.demo.BaseTest;
import net.admol.jingling.demo.aop.LogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : admol
 * @Date : 2019/10/24
 */
public class AopTest extends BaseTest{
    @Autowired
    LogService logService;
    @Test
    public void testAop(){
        Object object = new LogService();
        if(object instanceof LogService){
            System.out.println("111111111");
        }
        logService.testSave("admol");
    }
}
