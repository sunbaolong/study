package sbl.aop;

import org.springframework.stereotype.Component;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
@Component
public class AopInterfaceImpl implements AopInterface {
    public void test() {
        System.out.println("=========test=========");
    }
}
