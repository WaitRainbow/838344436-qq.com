package cn.cc.service;

import cn.cc.domain.PageBean;
import cn.cc.domain.User;
import cn.cc.domain.manager;

import java.util.List;
import java.util.Map;

public interface userService {
    //服务逻辑的抽象

    //查询数据库中的所有数据
    List<User> findAll();
    manager login(manager m);

    void add(User user);

    void delete(String id);

    User find(String id);

    void update(User user);


    void deleteSelect(String[] uids);

    PageBean<User> findByCondition(String currentPage, Map<String, String[]> condition);
}
