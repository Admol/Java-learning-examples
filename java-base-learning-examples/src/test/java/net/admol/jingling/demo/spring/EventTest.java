package net.admol.jingling.demo.spring;

import net.admol.jingling.demo.BaseTest;
import net.admol.jingling.demo.spring.event.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : admol
 * @Date : 2020/11/2
 */

public class EventTest extends BaseTest{
    @Autowired
    private UserService userService;

    @Test
    public void testUserEvent(){
        userService.register();
    }
}
