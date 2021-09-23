package com.ambow.service;

import com.ambow.dao.BookDao;
import com.ambow.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookInfo> selectallBook(){
       return bookDao.allBook();
    }

    public BookInfo selectbyidBook(int bid){
        return  bookDao.byidBook(bid);
    }

}
