package cn.cc.dao;

import cn.cc.domain.Manager;

public interface ManagerDao {
    /**
    *@Description 管理员登录功能
    *@Param [m] 管理员对象
    *@Return cn.cc.domain.manager
    *@Author cc
    *@Date 2020/4/1
    *@Time 15:19
    */
    Manager login(Manager m);
}
