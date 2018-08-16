package sbl.aop;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/10
 */
public interface DataHandle {

    void save(Student student) throws Exception;

    int delete(int id) throws Exception;

    int delete(Student student) throws Exception;

}
