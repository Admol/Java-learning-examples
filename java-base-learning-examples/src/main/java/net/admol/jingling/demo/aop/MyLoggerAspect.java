package net.admol.jingling.demo.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author : admol
 * @Date : 2019/10/24
 */

@Slf4j
@Aspect
@Component
@Lazy(false)
public class MyLoggerAspect{

    @Pointcut("@annotation(net.admol.jingling.demo.aop.AopLog)")
    private void cutMethod(){
        log.info("this is aspect cut method ! ");
    }

    @Before(value = "cutMethod()")
    private void before(){
        log.info("this is aspect cut before method ! ");
    }

    @AfterReturning("cutMethod()")
    private void after(){
        log.info("this is aspect cut AfterReturning method ! ");
    }

    @Around("cutMethod()")
    public void printLog(ProceedingJoinPoint pjp) throws Throwable{
        log.info("进入到环绕通知....");
        log.info("参数args:{}",JSON.toJSONString(pjp.getArgs()));
        // 获取目标方法的名称
        String methodName = pjp.getSignature().getName();
        // 获取方法传入参数
        Object[] params = pjp.getArgs();
        // 执行源方法  这个必须要  否则不会进入到before的切面, 但是会进入到AfterReturning
        pjp.proceed();
    }

}
