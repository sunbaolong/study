package designmode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by sunbaolong on 2017/11/21.
 */
public class Student implements Observer {

    private String name;

    public Student(Observable o, String name) {
        this.name = name;
        o.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        Teacher teacher = (Teacher) o;
        System.out.println("我是" + name + ",老师布置作业了，【告诉我】作业内容为：" + teacher.getInfo());
        System.out.println("我是" + name + ",老师布置作业了，【我询问】作业内容为：" + String.valueOf(arg));
    }

}
