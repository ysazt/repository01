package com.ambow.controller;

import com.alibaba.fastjson.JSONObject;
import com.ambow.entity.*;
import com.ambow.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ShopServcie shopServcie;
    @Autowired
    private UserServcie userServcie;
    @Autowired
    private OrderService orderService ;
    @Autowired
    private YuyueService yuyueService;


    @RequestMapping("allBook")
    public String allBook(HttpServletRequest request){

        request.setAttribute("allBook", bookService.selectallBook());
        return "index";
    }

    @RequestMapping("byidBook")
    public String allBook(int id ,HttpServletRequest request){

        request.setAttribute("book", bookService.selectbyidBook(id));
        return "bookDetail";
    }

    @RequestMapping("addShop")
    public String addShop(int bookid, int snum, HttpSession session){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo == null){
            return "login";
        }else{
            shopServcie.shijiAdd(userInfo.getUid(),bookid,snum);
            return "forward:myshop";
        }
    }

    @RequestMapping("myshop")
    public String myshop ( HttpSession session,HttpServletRequest request){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            List<ShopInfo> shopInfoList = shopServcie.selectmyShopNow(userInfo.getUid());
            request.setAttribute("shopList" , shopInfoList);
            return  "myshop";
        }

    }

    @RequestMapping("addOrder")
    public String addOrder(String sid , String snum, HttpSession session ){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            orderService.addOrderServcie(sid, snum,userInfo);
            return "forward:myorderNotPay";
        }

    }

    @RequestMapping("myorderNotPay")
    public String myorderNotPay( HttpSession session,HttpServletRequest request){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            request.setAttribute("myorder", orderService.selectmyOrderNoPay(userInfo.getUid()));
            return "myorderNotPay" ;
        }
    }

    @RequestMapping("myorderPay")
    public String myorderPay( HttpSession session,HttpServletRequest request){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            request.setAttribute("myorder", orderService.selectmyOrderPay(userInfo.getUid()));
            return "myorderPay" ;
        }
    }

    @RequestMapping("chongzhi")
    public String chongzhi(double money , HttpSession session){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            userInfo.setUmoeny(userInfo.getUmoeny()+money);
            userServcie.chongzhiMoneyServcie(userInfo);
            return "forward:allBook";
        }

    }

    @RequestMapping("zhifu")
    public String zhifu(double qian,int oid,HttpSession session){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else{
            userInfo.setUmoeny(userInfo.getUmoeny()-qian);
            userServcie.chongzhiMoneyServcie(userInfo);
            //修改订单状态
            OrderInfo orderInfo = new OrderInfo() ;
            orderInfo.setOid(oid);
            orderInfo.setOflag(1);
            orderService.updateOrderFlag(orderInfo);
            return "forward:myorderPay";
        }
    }

    @RequestMapping("login")
    public String login(UserInfo userInfo, HttpSession session){
        UserInfo loginUser = userServcie.selectloginServcie(userInfo);
        if(loginUser== null){
            return "login";
        }else{
            session.setAttribute("users" ,loginUser);
            return "forward:allBook";
        }
    }

    @RequestMapping("yuyue")
    public String yuyue(HttpSession session,HttpServletRequest request){
        UserInfo userInfo =(UserInfo) session.getAttribute("users");
        if(userInfo== null){
            return "login";
        }else {
            YuyueInfo yuyueInfo = yuyueService.selectbyuidYuyue(userInfo.getUid());
            if(yuyueInfo == null){
              // request.setAttribute("books" , bookService.selectallBook());
                return "yuyueAdd";
            }else{
                System.out.println("有预约中的值");
                return "index";
            }


        }
    }

    // 根据时间 返回有哪些书可以预约
    @RequestMapping("allBookByTime")
    @ResponseBody
    public String allBookByTime(String time ){
        List<BookInfo> list = yuyueService.selectByTime(time);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("books",list);
        return jsonObject.toJSONString();
    }
}
