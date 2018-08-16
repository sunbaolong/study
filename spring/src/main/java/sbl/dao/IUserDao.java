package sbl.dao;

import sbl.entity.User;

import java.util.List;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/8/16
 */
public interface IUserDao {

    void save(User user);

    List<User> getUsers();

}
