package cn.cc.service.impl;

import cn.cc.DAO.Impl.managerDaoImpl;
import cn.cc.DAO.Impl.userDaoImpl;
import cn.cc.DAO.userDao;
import cn.cc.domain.PageBean;
import cn.cc.domain.User;
import cn.cc.domain.manager;
import cn.cc.service.userService;

import javax.crypto.interfaces.PBEKey;
import java.util.List;
import java.util.Map;

//对抽象逻辑的具体实现
public class userServiceImpl implements userService {
    //该逻辑与数据库操作逻辑重合 可直接调用
    userDaoImpl userDao = new userDaoImpl();
    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public manager login(manager m) {
        manager loginUser = new manager();
        loginUser.setUsername(m.getUsername());
        loginUser.setPassword(m.getPassword());

        managerDaoImpl managerDaoImpl = new managerDaoImpl();
        manager result = managerDaoImpl.login(loginUser);
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
        pb.setTotalNumber(new userDaoImpl().totalNumber(condition));
        pb.setCurrentPage(cur);
        pb.setTotalPage(pb.getTotalNumber() % pb.getRows()==0 ? pb.getTotalNumber() / pb.getRows() :
                pb.getTotalNumber() / pb.getRows() +1 );
        int start = (cur -1) * pb.getRows();
        pb.setList(new userDaoImpl().findByCondition(start,pb.getRows(),condition));
        System.out.println(pb.getTotalNumber()+" "+pb.getTotalPage());
        return pb;
    }
}
