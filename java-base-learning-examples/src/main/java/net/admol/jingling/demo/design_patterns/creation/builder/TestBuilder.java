package net.admol.jingling.demo.design_patterns.creation.builder;

/**
 * 构建者模式使用
 * @author : jingling
 * @Date : 2021/7/28
 */
public class TestBuilder{

    public static void main(String[] args){
        TestBuilder t = new TestBuilder();
        System.out.println(t.testNormal());
        System.out.println(t.testMinMoreThanCoreSize());
        System.out.println(t.testNoneName());
    }

    public ResourceConfig testNormal(){
        ResourceConfig config = new ResourceConfig.Builder()
                .setCoreSize(8)
                .setMaxSize(200)
                .setMinSize(6)
                .setName("默认资源配置")
                .build(); // 最后调用build方法
        return config;
    }

    public ResourceConfig testMinMoreThanCoreSize(){
        ResourceConfig config = new ResourceConfig.Builder()
                .setCoreSize(8)
                .setMaxSize(200)
                .setMinSize(16)
                .setName("默认资源配置")
                .build(); // 最后调用build方法
        return config;
    }

    public ResourceConfig testNoneName(){
        ResourceConfig config = new ResourceConfig.Builder()
                .setCoreSize(8)
                .setMaxSize(200)
                .setMinSize(6)
                .build(); // 最后调用build方法
        return config;
    }
}
