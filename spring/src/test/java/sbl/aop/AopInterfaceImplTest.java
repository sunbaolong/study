package sbl.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbl.SpringConfig;

import static org.junit.Assert.*;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AopInterfaceImplTest {

    @Autowired
    private AopInterface aopInterface;

    @Test
    public void test1() throws Exception {
        aopInterface.test();
    }

}
