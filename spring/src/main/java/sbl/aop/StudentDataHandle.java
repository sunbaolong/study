package sbl.aop;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
@Component
public class StudentDataHandle implements DataHandle {
    public void save(Student student) throws Exception {
        System.out.println("save data");
        throwException();
    }

    public int delete(int id) throws Exception {
        System.out.println("delete data,id=" + id);
        throwException();
        return 1;
    }

    public int delete(Student student) throws Exception {
        System.out.println("delete data,student=" + student);
        throwException();
        return 1;
    }

    private static void throwException() throws Exception {
        int random = (int)(Math.random() * 10);
        if (random > 7) {
            throw new Exception();
        }
    }
}
