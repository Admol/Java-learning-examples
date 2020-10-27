package net.admol.jingling.demo.dynamic;

import javax.annotation.processing.AbstractProcessor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : admol
 * @Date : 2020/9/29
 */
public class TestDynamicProxy{
    interface IHello{
        void sayHello();
    }
    static class Hello implements IHello{
        @Override
        public void sayHello(){
            System.out.println("Hello World!");
        }
    }
    static class DynamicProxy implements InvocationHandler{
        private Object object;
        public Object build(Object object){
            this.object = object;
            Class c = object.getClass();
            // 返回指定类的代理类示例
            return Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
            // 代理类的代理行为,被代理类的行为未知情况下也可以对被代理类进行行为增强
            System.out.println("welcome");
            return method.invoke(object,args);
        }
    }

    /**
     * 指定JVM参数，-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true，保存动态代理的字节码 $Proxy0
     * @param args
     */
    public static void main(String[] args){
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IHello hello = (IHello) new DynamicProxy().build(new Hello());
        hello.sayHello();
    }

}
