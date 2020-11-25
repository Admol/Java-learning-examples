package cn.jinglingwang.eureka.provider.controller;

import cn.jinglingwang.eureka.provider.dto.UserDTO;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author : jingling
 * @Date : 2020/11/24
 */
@Controller
public class HelloController{

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "hello")
    public String hello(HttpServletRequest request) throws UnsupportedEncodingException{
        String header = request.getHeader("Authorization");
        if(header != null && header.length() > 6){
            String authorization = new String(Base64.decode(header.substring(6).getBytes("UTF-8")),"UTF-8");
            System.out.println(authorization);
        }
        return "hello, my name is eureka provider!";
    }

    public static void main(String[] args) throws UnsupportedEncodingException{
        String token = new String(Base64.decode("dXNlcm5hbWU6amluZ2xpbmd3YW5nLmNu".getBytes("UTF-8")),
                "UTF-8");
        System.out.println(token);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "query")
    public String query(UserDTO user){
        String name = user.getName();
        Integer age = user.getAge();
        return "user: " + name + " exists！age:"+age;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "queryNoReturn")
    public void queryNoReturn(UserDTO user){
        String name = user.getName();
        Integer age = user.getAge();
        System.out.println( "user: " + name + " exists！age:"+age);
    }


}
