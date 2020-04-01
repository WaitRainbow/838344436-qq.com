package cn.cc.service.impl;

import cn.cc.dao.impl.ManagerDaoImpl;
import cn.cc.dao.impl.UserDaoImpl;
import cn.cc.domain.PageBean;
import cn.cc.domain.User;
import cn.cc.domain.Manager;
import cn.cc.service.UserService;

import java.util.List;
import java.util.Map;

//对抽象逻辑的具体实现
public class UserServiceImpl implements UserService {
    //该逻辑与数据库操作逻辑重合 可直接调用
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public Manager login(Manager m) {
        Manager loginUser = new Manager();
        loginUser.setUsername(m.getUsername());
        loginUser.setPassword(m.getPassword());

        ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();
        Manager result = managerDaoImpl.login(loginUser);
        return result;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User find(String id) {
        return userDao.find(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteSelect(String[] uids) {
        for (int i = 0; i < uids.length; i++) {
            String uid = uids[i];
            userDao.delete(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<User> findByCondition(String currentPage, Map<String, String[]> condition) {
        PageBean<User> pb = new PageBean<>();
        int cur = Integer.parseInt(currentPage);
        if (cur <= 0) {
            cur = 1;
        }
        pb.setTotalNumber(new UserDaoImpl().totalNumber(condition));
        pb.setCurrentPage(cur);
        pb.setTotalPage(pb.getTotalNumber() % pb.getRows()==0 ? pb.getTotalNumber() / pb.getRows() :
                pb.getTotalNumber() / pb.getRows() +1 );
        int start = (cur -1) * pb.getRows();
        pb.setList(new UserDaoImpl().findByCondition(start,pb.getRows(),condition));
        System.out.println(pb.getTotalNumber()+" "+pb.getTotalPage());
        return pb;
    }
}
