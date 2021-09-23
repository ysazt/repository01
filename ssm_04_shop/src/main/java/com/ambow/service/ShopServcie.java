package com.ambow.service;

import com.ambow.utils.Tools;
import com.ambow.dao.ShopDao;
import com.ambow.entity.BookInfo;
import com.ambow.entity.ShopInfo;
import com.ambow.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServcie {
    @Autowired
    private ShopDao shopDao;

    public List<ShopInfo> selectmyShopNow(int uid){
        return shopDao.myShop(uid,"0");
    }

    public List<ShopInfo> selectmyShopHistory(int uid){
        return shopDao.myShop(uid,"1");
    }

    public void addShop(ShopInfo shopInfo){
        shopInfo.setStime(new Tools().getTime());
        shopInfo.setSflag("0");
        shopDao.addShop(shopInfo);
    }

    public void updateShop(ShopInfo shopInfo){
        shopDao.updateShop(shopInfo);
    }

    public ShopInfo selectmyShopBook(int uid , int bookid){
        return  shopDao.myShopBook(uid,bookid)  ;
    }

    public void shijiAdd(int uid , int bookid ,int num){
        ShopInfo shopInfo = selectmyShopBook(uid,bookid);
        if(shopInfo == null){
            System.out.println("此人无此书，增加操作");
            ShopInfo shop = new ShopInfo();
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookid(bookid);
            shop.setSbid(bookInfo);
            UserInfo userInfo = new UserInfo();
            userInfo.setUid(uid);
            shop.setSuid(userInfo);
            shop.setSnum(num);
            addShop(shop);
        }else{
            System.out.println("有次数， 修改操作");
            int old = shopInfo.getSnum();
            int now = old+num ;
            shopInfo.setSnum(now);
            updateShop(shopInfo);
        }

    }
}
