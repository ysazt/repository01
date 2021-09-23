package com.ambow.dao;

import com.ambow.entity.BookInfo;

import java.util.List;

public interface BookDao {

    public List<BookInfo> allBook();

    public BookInfo byidBook(int id);

    public void updateBook(BookInfo bookInfo);


}
