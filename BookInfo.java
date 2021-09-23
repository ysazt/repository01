package com.ambow.entity;

import lombok.Data;

@Data
public class BookInfo {
    private int bookid;
    private String bname ;
    private double bprice ;
    private int bnum ;
    private String bimg ;
    private String bflag ;


    @Override
    public String toString() {
        return "BookInfo{" +
                "bookid=" + bookid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bnum=" + bnum +
                ", bimg='" + bimg + '\'' +
                ", bflag='" + bflag + '\'' +
                '}';
    }
}
