package cn.cc.test;

import cn.cc.domain.User;
import cn.cc.service.impl.userServiceImpl;

import java.util.List;

public class test {
    public static void main(String[] args) {
        userServiceImpl userService = new userServiceImpl();
        List<User> Users = userService.findAll();
        for(User u:Users) {
            System.out.println(u);
        }
    }

}
