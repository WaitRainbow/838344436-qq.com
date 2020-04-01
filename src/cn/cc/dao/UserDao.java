package cn.cc.dao;

import cn.cc.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //对数据库的操作逻辑

    /**
    *@Description 查询数据库中所有记录
    *@Param []
    *@Return java.util.List<cn.cc.domain.User>
    *@Author cc
    *@Date 2020/4/1
    *@Time 13:47
    */
    List<User> findAll();

    /**
    *@Description 添加用户到数据库
    *@Param [user] 用户对象
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 13:54
    */
    void add(User user);

    /**
    *@Description 根据id删除用户
    *@Param [id] 用户id
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:17
    */
    void delete(int id);

    /**
    *@Description 根据id查询用户
    *@Param [id] 用户id
    *@Return cn.cc.domain.User
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:17
    */
    User find(int id);

    /**
    *@Description 更新用户信息
    *@Param [user] 更新的用户信息
    *@Return void
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:18
    */
    void update(User user);

    /**
    *@Description 根据条件查询到的用户总数
    *@Param [condition] 查询条件
    *@Return int
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:21
    */
    int totalNumber(Map<String, String[]> condition);


    /**
    *@Description 根据条件查询到的用户
    *@Param [start：分页起始序号, end：每页条目数, condition：查询条件]
    *@Return java.util.List<cn.cc.domain.User>
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:25
    */
    List<User> findByCondition(int start,int end, Map<String, String[]> condition);
}
