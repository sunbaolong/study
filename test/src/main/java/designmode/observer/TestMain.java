package designmode.observer;

/**
 * Created by sunbaolong on 2017/11/21.
 */
public class TestMain {


    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        Student student1 = new Student(teacher, "小明");
        Student student2 = new Student(teacher, "小红");
        Student student3 = new Student(teacher, "小李");

        teacher.setInfo("作文");
    }

}
