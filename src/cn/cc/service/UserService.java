package cn.cc.service;

import cn.cc.domain.PageBean;
import cn.cc.domain.User;
import cn.cc.domain.Manager;

import java.util.List;
import java.util.Map;

public interface UserService {
    //服务逻辑的抽象

    /**
    *@Description 查询数据库中的所有数据
    *@Param []
    *@Return java.util.List<cn.cc.domain.User>
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:28
    */
    List<User> findAll();

    /**
    *@Description 管理员登录功能
    *@Param [m] 管理员对象
    *@Return cn.cc.domain.manager
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:28
    */
    Manager login(Manager m);

    /**
    *@Description 添加用户
    *@Param [user] 用户对象
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:29
    */
    void add(User user);

    /**
    *@Description 根据id删除指定用户
    *@Param [id] 用户id
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:30
    */
    void delete(String id);

    /**
    *@Description 根据id查询指定用户
    *@Param [id] 用户id
    *@Return cn.cc.domain.User
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:30
    */
    User find(String id);

    /**
    *@Description 更新用户数据
    *@Param [user] 待更新的用户数据
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:30
    */
    void update(User user);

    /**
    *@Description 根据id批量删除用户
    *@Param [uids] 用户id集合
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:36
    */
    void deleteSelect(String[] uids);

    /**
    *@Description 根据条件查询
    *@Param [currentPage：当前页码, condition：查询条件]
    *@Return cn.cc.domain.PageBean<cn.cc.domain.User> 返回PageBean对象
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:37
    */
    PageBean<User> findByCondition(String currentPage, Map<String, String[]> condition);
}
