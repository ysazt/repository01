package com.ambow.servcie;

import com.ambow.entity.UserInfo;
import com.ambow.service.UserServcie;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServcieTest {

    @Test
    public void login(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        UserServcie userServcie = applicationContext.getBean(UserServcie.class);
        UserInfo loginUser = new UserInfo();
        loginUser.setUname("lucy");
        loginUser.setUpwd("1233");
        UserInfo userInfo = userServcie.selectloginServcie(loginUser);
        System.out.println(userInfo);
    }

    @Test
    public void chongzhiPwd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        UserServcie userServcie = applicationContext.getBean(UserServcie.class);
        userServcie.chongzhiPwdService("lucy");
    }

    @Test
    public void chongzhiMoney(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        UserServcie userServcie = applicationContext.getBean(UserServcie.class);
        UserInfo loginUser = new UserInfo();
        loginUser.setUname("lucy");
        loginUser.setUpwd("123456");
        UserInfo userInfo = userServcie.selectloginServcie(loginUser);
        userInfo.setUmoeny(200+userInfo.getUmoeny());
        userServcie.chongzhiMoneyServcie(userInfo);
    }
}
