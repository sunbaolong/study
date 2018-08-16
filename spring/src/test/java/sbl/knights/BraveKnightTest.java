package sbl.knights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbl.SpringConfig;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/6/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BraveKnightTest {
    @Autowired
    private Knight knight;

    @Test
    public void embarkOnQuest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }

    @Test
    public void testJavaGetXml() {
        knight.embarkOnQuest();
    }

}
