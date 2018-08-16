package sbl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sbl.dao.IUserDao;
import sbl.dao.UserDaoImpl;
import sbl.entity.User;

import java.util.List;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/8/16
 */
public class JdbcTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        IUserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        User user = new User();
        user.setName("sunbaolong");
        user.setAge(27);
        user.setSex("男");
        userDao.save(user);

        List<User> list = userDao.getUsers();
        for (User u : list) {
            System.out.println(u);
        }
    }

}
