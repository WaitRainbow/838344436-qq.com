package cn.cc.dao.impl;

import cn.cc.dao.UserDao;
import cn.cc.domain.User;
import cn.cc.utils.JDBCutils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());
    @Override
    public List<User> findAll() {
        //查询所有记录
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User find(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());

    }

    @Override
    public int totalNumber(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<String> values = new LinkedList<>();
        for (String key : keys) {
            if ("currentPage".equals(key)) {
                continue;
            }
            String[] value = condition.get(key);
            if (value[0] != null && value[0].length() != 0) {
                sb.append(" and "+key +" like ? ");
                values.add("%"+value[0]+"%");
            }
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, values.toArray());
    }

    @Override
    public List<User> findByCondition(int start,int end, Map<String, String[]> condition) {
        String sql = "select * from user where 1 =1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<Object> values = new ArrayList<>();
        for (String key : keys) {
            if ("currentPage".equals(key)) {
                continue;
            }
            String[] value = condition.get(key);
            if (value[0] != null && value[0].length() != 0) {
                sb.append(" and "+key +" like ? ");
                 values.add("%"+value[0]+"%");
            }
        }
        sb.append(" limit ? , ? ");
        sql = sb.toString();
        values.add(start);
        values.add(end);
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), values.toArray());
        return users;

    }
}
