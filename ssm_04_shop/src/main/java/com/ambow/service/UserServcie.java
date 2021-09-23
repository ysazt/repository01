package com.ambow.service;

import com.ambow.dao.UserDao;
import com.ambow.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServcie {

    @Autowired
    private UserDao userDao;

    public UserInfo selectloginServcie(UserInfo userInfo){
        return userDao.loginDao(userInfo);
    }

    public void chongzhiMoneyServcie(UserInfo userInfo){
        userDao.userUmoenyDao(userInfo);
    }

    public void chongzhiPwdService(String name) {
        userDao.chognzhiPwd(name);
    }


}
