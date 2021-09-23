package com.ambow.entity;

import lombok.Data;

@Data
public class OrderDetailInfo {

    private int odid ;
    private BookInfo obid ;
    private double oprice ;
    private int onum ;
    private OrderInfo orderid;
}
