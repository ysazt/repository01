package com.ambow.entity;

import lombok.Data;

@Data
public class ShopInfo {
    private int shopid;
    private UserInfo suid ;
    private BookInfo sbid;
    private int snum ;
    private String stime ;
    private String sflag ;//0 可以展示 1 删除
}
