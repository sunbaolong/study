package sbl.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
@Aspect
@Component
public class AopInterfaceProxy {

    @Before("execution(* sbl.aop.AopInterface.test(..))")
    public void before() {
        System.out.println("++++++++before+++++++++");
    }

}
