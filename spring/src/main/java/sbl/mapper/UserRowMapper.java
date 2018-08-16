package sbl.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbl.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/8/16
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setSex(rs.getString("sex"));
        return user;
    }
}
