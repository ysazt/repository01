package com.ambow.servcie;

import com.ambow.entity.BookInfo;
import com.ambow.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookServcieTest {

    @Test
    public void testall(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        BookService bookService = applicationContext.getBean(BookService.class);

        List<BookInfo> list = bookService.selectallBook();
        for (BookInfo item : list){
            System.out.println(item);
        }
    }

    @Test
    public void testbyid(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        BookService bookService = applicationContext.getBean(BookService.class);

        BookInfo byid = bookService.selectbyidBook(1);
        System.out.println(byid);
    }
}
