package sbl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import sbl.custombean.User;
import sbl.knights.BraveKnight;
import sbl.knights.Knight;

import java.io.InputStream;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/2
 */
public class Init {

    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
//        BraveKnight knight = bf.getBean("knight", BraveKnight.class);
//        knight.embarkOnQuest();
        User user = bf.getBean("mybean", User.class);
        System.out.println(user.getUsername() + ":" + user.getEmail());

//        InputStream is = Init.class.getResourceAsStream("/spring.xml");
//        InputStream is1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("spring.xml");
//        System.out.println(is == null);
//        System.out.println(is1 == null);
    }

}
