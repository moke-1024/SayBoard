package com.sayboard.service;

import com.sayboard.dao.UserDao;
import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;

/**
 * @outhor moke
 * @date 2019-11-25
 */
public class UserService {
    UserDao userDao = new UserDao();

    public User loginUser(String empName, String password) {
        User findUser = userDao.findUserByempNameAndPassword(empName,password);
        if (findUser == null){
            throw new MsgException("用户名或密码错误");
        }
        return findUser;
    }

    public void registUser(User user) {
        boolean flag = userDao.findUserByUsername(user.getEmpName());
        if (flag){
            throw new MsgException("用户名已存在");
        }else {
            userDao.addUser(user);
        }
    }

    public boolean checkisnullUser(String empName) {
        return userDao.findUserByUsername(empName);
    }

    public boolean findacceptUser(String acceptname) {
        boolean flag = userDao.findUserByUsername(acceptname);
        if (flag){
            return true;
        }else {
            throw new MsgException("此用户未注册");
        }
    }
}
