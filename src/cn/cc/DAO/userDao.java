package cn.cc.DAO;

import cn.cc.domain.PageBean;
import cn.cc.domain.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

public interface userDao {
    //对数据库的操作逻辑
    List<User> findAll();

    void add(User user);

    void delete(int id);

    User find(int parseInt);

    void update(User user);

    int totalNumber(Map<String, String[]> condition);

    List<User> findByCondition(int start,int end, Map<String, String[]> condition);
}
