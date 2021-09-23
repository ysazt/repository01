package com.ambow.servcie;

import com.ambow.entity.BookInfo;
import com.ambow.entity.ShopInfo;
import com.ambow.entity.UserInfo;
import com.ambow.service.ShopServcie;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopServcieTest {

    /*
    *   第一次来的， 你就是添加
		    二      ，  我的购物车是否有此商品
			            没有--》 添加
						有， -- 取原来的+ 本次的数量 --》修改
	  第几次： 需要查一个当前登陆这是否有该商品
	*/
    @Test
    public void testadd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        ShopServcie servcie = applicationContext.getBean(ShopServcie.class);
        int uid  = 2 ;
        int bookid = 3;
        int num = 1;
        ShopInfo shopInfo = servcie.selectmyShopBook(uid,bookid);
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

            servcie.addShop(shop);
        }else{
            System.out.println("有次数， 修改操作");
            int old = shopInfo.getSnum();
            int now = old+num ;
            shopInfo.setSnum(now);
            servcie.updateShop(shopInfo);

        }




    }
}
