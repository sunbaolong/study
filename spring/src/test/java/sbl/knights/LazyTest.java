package sbl.knights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbl.SpringConfig;
import sbl.cd.CompactDisc;
import sbl.cd.SgtPeppers;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class LazyTest {

    @Autowired
    private CompactDisc sgtPeppers;

    @Test
    public void testLazy() {
        System.out.println("测试");
        sgtPeppers.play();
    }

    @Test
    public void testLazy1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("Bean Factory Initialized !!");
        CompactDisc compactDisc = ctx.getBean(CompactDisc.class);
        compactDisc.play();
    }

}
