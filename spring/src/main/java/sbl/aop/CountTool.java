package sbl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
@Aspect
@Component
public class CountTool {

    @Pointcut("execution(* sbl.aop.DataHandle.save(..))")
    public void save() {}

    @Pointcut("execution(* sbl.aop.DataHandle.delete(..)) && args(id)")
    public void delete(int id) {}

    @Before("save()")
    public void invokeSaveBefore() {
        System.out.println("invoke save before");
    }

    @After("save()")
    public void invokeSaveAfter() {
        System.out.println("invoke save after");
    }

    @AfterReturning("save()")
    public void invokeSaveReturn() {
        System.out.println("invoke save after return");
    }

    @AfterThrowing("save()")
    public void invokeSaveException() {
        System.out.println("invoke save exception");
    }

    @Around("save()")
    public void invokeSaveAround(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("before");
            joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable throwable) {
            System.out.println("exception");
            throwable.printStackTrace();
        }
    }

    @Before("delete(id)")
    public void invokeDeleteBefore(int id) {
        System.out.println("invoke delete before,id=" + id);
    }

    @After("delete(id)")
    public void invokeDeleteAfter(int id) {
        System.out.println("invoke delete after,id=" + id);
    }

}
