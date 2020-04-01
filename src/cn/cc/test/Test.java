package cn.cc.test;

import cn.cc.domain.User;
import cn.cc.service.impl.UserServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        for(User u:users) {
            System.out.println(u);
        }
    }

}
