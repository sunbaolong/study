package serializable;

import java.io.*;
import java.util.Date;

/**
 * Created by sunbaolong on 2017/11/22.
 */
public class Student implements Serializable {

    private String name;
    private char sex;
    private int age;
    private Date birth;

    public Student(String name, char sex, int age, Date birth) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Student student1 = new Student("张三", '男', 10, new Date());
        Student student2 = new Student("李四", '男', 10, new Date());
        File file = new File("//Users/sunbaolong/work/test/student.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student1);
        oos.writeObject(student2);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student std1 = (Student) ois.readObject();
        Student std2 = (Student) ois.readObject();
        System.out.println(std1);
        System.out.println(std2);

    }
}
