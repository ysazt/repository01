package com.ambow.dao;

import com.ambow.entity.UserInfo;

public interface UserDao {

    public UserInfo loginDao(UserInfo userInfo);

    public void userUmoenyDao(UserInfo userInfo);

    public void chognzhiPwd(String name);




}
