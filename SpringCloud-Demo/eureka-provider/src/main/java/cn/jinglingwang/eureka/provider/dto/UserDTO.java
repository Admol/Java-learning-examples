package cn.jinglingwang.eureka.provider.dto;

/**
 * @author : jingling
 * @Date : 2020/11/24
 */
public class UserDTO{
    String name;
    Integer age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
