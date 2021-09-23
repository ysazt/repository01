package com.ambow.service;

import com.ambow.dao.BookDao;
import com.ambow.dao.OrderDao;
import com.ambow.dao.OrderDetailDao;
import com.ambow.dao.ShopDao;
import com.ambow.entity.*;
import com.ambow.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao ;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private ShopDao shopDao ;

    @Autowired
    private BookDao bookDao;

    public void addOrderServcie(String sid, String snum, UserInfo userInfo) {
       String sids[]= sid.split("-"); // 购物车id
       String snum1[] = snum.split("-");// 对应的数量

       OrderInfo orderInfo = new OrderInfo();
       orderInfo.setOflag(0);
       orderInfo.setOtime(new Tools().getTime());
       orderInfo.setOuid(userInfo);
        System.out.println("---before......."+orderInfo);
       orderDao.addOrder(orderInfo);
        System.out.println("=----after add ..."+orderInfo);

        for(int i = 0 ; i < sids.length ; i ++){
           ShopInfo shopInfo = shopDao.byidShop(Integer.parseInt(sids[i]));// 根据购物车id   取购物车所有信息
            int nownum = Integer.parseInt(snum1[i]) ;
            OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
            orderDetailInfo.setObid(shopInfo.getSbid());
            orderDetailInfo.setOnum(nownum);
            orderDetailInfo.setOprice(shopInfo.getSbid().getBprice());
            orderDetailInfo.setOrderid(orderInfo);
            orderDetailDao.addOrderDetail(orderDetailInfo);

            // 修改购物车 ， 改购物车的状态
            shopInfo.setSflag("1");
            shopDao.updateShopFlag(shopInfo);

            // 商品库存量操作
            BookInfo bookInfo = shopInfo.getSbid();
            int last = bookInfo.getBnum()-nownum ;
            bookInfo.setBnum(last);
            bookDao.updateBook(bookInfo);

        }
        // 未支付

    }

    // 未支付
    public List<OrderDetailInfo> selectmyOrderNoPay(int uid){
        return orderDao.myOrder(uid,0);
    }

    // 已支付
    public List<OrderDetailInfo> selectmyOrderPay(int uid){
        return orderDao.myOrder(uid,1);
    }

    // 我的所有
    public List<OrderDetailInfo> selectAllOrder(int uid){
        List<OrderDetailInfo> list = new ArrayList<>();
        list.addAll(selectmyOrderPay(uid));
        list.addAll(selectmyOrderNoPay(uid));
        return list ;
    }

    public void updateOrderFlag(OrderInfo orderInfo){

        orderDao.updateOrder(orderInfo);
    }
}
