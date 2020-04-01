package cn.cc.dao.impl;

import cn.cc.dao.ManagerDao;
import cn.cc.domain.Manager;
import cn.cc.utils.JDBCutils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ManagerDaoImpl implements ManagerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());
    @Override
    public Manager login(Manager m) {
            try {
                String sql = "select * from manager where username=? and password=?";
                Manager m1 = template.queryForObject(sql, new BeanPropertyRowMapper<Manager>(Manager.class),
                        m.getUsername(), m.getPassword());
                return m1;
            } catch (DataAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

