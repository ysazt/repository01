package com.ambow.service;

import com.ambow.dao.BookDao;
import com.ambow.dao.YuyueDao;
import com.ambow.entity.BookInfo;
import com.ambow.entity.YuyueInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YuyueService {

    @Autowired
    private YuyueDao yuyueDao ;
    @Autowired
    private BookDao bookDao;

    public void addyuyue(YuyueInfo yuyueInfo){
        yuyueDao.addYuyue(yuyueInfo);
    }

    public YuyueInfo selectbyuidYuyue(int uid){
        return yuyueDao.byUidYuyue(uid);
    }

    public List<BookInfo> selectByTime(String time) {
        List<BookInfo> list = new ArrayList<>();
        // 获取所有在预约中的图书id
       List<Integer> listBookIdYu = yuyueDao.byFlagYuyue(0);
       // 获取所有图书
       List<BookInfo> allBook = bookDao.allBook();
       // 我要的是没有在预约中的图书
        for (BookInfo book : allBook){ //1,2,3,4,5,6,7,8
             int flag = 0 ;
              for(Integer item : listBookIdYu){  //[1,4,8]
                 if(book.getBookid() == item ){
                      flag = 1;
                     break ;
                  }
                }
               if(flag == 0 ){
                   list.add(book);
               }
        }

        return list ;
    }
}
