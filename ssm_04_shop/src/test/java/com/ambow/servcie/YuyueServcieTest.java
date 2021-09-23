package com.ambow.servcie;

import com.ambow.entity.BookInfo;
import com.ambow.service.YuyueService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class YuyueServcieTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        YuyueService yuyueService = applicationContext.getBean(YuyueService.class);
        List<BookInfo> list = yuyueService.selectByTime("2021-09-20T16:39");
        for (BookInfo item : list){
            System.out.println(item);
        }
    }
}
