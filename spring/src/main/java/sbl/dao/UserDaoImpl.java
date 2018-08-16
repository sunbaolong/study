package sbl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import sbl.entity.User;
import sbl.mapper.UserRowMapper;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/8/16
 */
public class UserDaoImpl implements IUserDao {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        String sql = "insert into user(name, age, sex) values(?, ?, ?)";
        Object[] objects = {user.getName(), user.getAge(), user.getSex()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
        jdbcTemplate.update(sql, objects, types);
    }

    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }
}
