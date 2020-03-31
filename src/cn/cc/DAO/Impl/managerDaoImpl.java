package cn.cc.DAO.Impl;

import cn.cc.DAO.managerDao;
import cn.cc.domain.User;
import cn.cc.domain.manager;
import cn.cc.utils.JDBCutils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class managerDaoImpl implements managerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());
    @Override
    public manager login(manager m) {
            try {
                String sql = "select * from manager where username=? and password=?";
                manager m1 = template.queryForObject(sql, new BeanPropertyRowMapper<manager>(manager.class),
                        m.getUsername(), m.getPassword());
                return m1;
            } catch (DataAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

