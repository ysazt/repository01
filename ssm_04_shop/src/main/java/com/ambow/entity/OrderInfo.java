package com.ambow.entity;

import lombok.Data;

@Data
public class OrderInfo {

    private int oid ;
    private UserInfo ouid ;
    private String otime ;
    private int oflag ;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oid=" + oid +
                ", ouid=" + ouid +
                ", otime='" + otime + '\'' +
                ", oflag=" + oflag +
                '}';
    }
}
